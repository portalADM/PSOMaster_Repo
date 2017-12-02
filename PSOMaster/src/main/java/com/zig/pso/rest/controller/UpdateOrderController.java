/************************************************************************************************************
 * Class Name : UpdateOrderController.java 
 * Description: 
 * Author : Ankita Mishra 
 * Date : Aug 1, 2016 
 * **********************************************************************************************************
 */
package com.zig.pso.rest.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.AllowedUpdatesResponseBean;
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.BulkUpdateInputBean;
import com.zig.pso.rest.bean.BulkUpdateOrderResponseBean;
import com.zig.pso.rest.bean.UpdateMultiOrderDetailsRequestBean;
import com.zig.pso.rest.bean.UpdateOrderRequestBean;
import com.zig.pso.rest.bean.ValidatedBulkUpdateOrderDetailsBean;
import com.zig.pso.service.UpdateOrderManagerService;

/**
 * 
 */
@RestController
@MultipartConfig(fileSizeThreshold = 20971520)
public class UpdateOrderController
{
    @Autowired
    UpdateOrderManagerService updateService;

    @RequestMapping(value = "/updateOrder", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean> updateSingleOrder(@RequestBody UpdateOrderRequestBean updateOrderRequest)
    {
        String updateDetails = "Order ID : "+updateOrderRequest.getOrderId()+" \nNew Value : "+updateOrderRequest.getNewValue()+" \nUpdate Type : "+updateOrderRequest.getType()+" \nLine Id : "+updateOrderRequest.getLineId();
        PSOLoggerSrv.printDEBUG("UpdateOrderController", "updateSingleOrder", updateDetails);

        BaseResponseBean nameList = new BaseResponseBean();
        nameList = updateService.updateSingleOrderData(updateOrderRequest);
        return new ResponseEntity<BaseResponseBean>(nameList, HttpStatus.OK);
    }

    @RequestMapping(value = "/upload/{updateType}", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean> uploadFile(HttpServletRequest request, @RequestParam Map<String, Object> params, @PathVariable("updateType") String updateType)
    {
        PSOLoggerSrv.printDEBUG("UpdateOrderController", "uploadFile", "updateType : "+updateType);
        
        BulkUpdateOrderResponseBean bulkUpdateResponse = new BulkUpdateOrderResponseBean();
        if (request instanceof MultipartRequest)
        {
            BaseResponseBean response = new BaseResponseBean();
            MultipartFile file = ((MultipartRequest) request).getFile("file");

            BulkUpdateInputBean orderBulkData = updateService.getUploadedFileData(file, updateType);

            ValidatedBulkUpdateOrderDetailsBean validatedOrders = updateService.validateUploadedData(orderBulkData);
            if(null!=validatedOrders.getValidOrderData())
            {
                
                bulkUpdateResponse.setTempTableDataList(validatedOrders.getValidOrderData());
                bulkUpdateResponse.setBulkUpdateId(validatedOrders.getValidOrderData().get(0).getBulkUpdateId());
                
                bulkUpdateResponse.setErrorCode(response.getErrorCode());
                bulkUpdateResponse.setErrorMsg(response.getErrorMsg());
                bulkUpdateResponse.setLogRefId(response.getLogRefId());
            }
            else
            {
                bulkUpdateResponse.setErrorCode(PSOConstants.SUCCESS_CODE);
                bulkUpdateResponse.setErrorMsg(PSOConstants.NO_VALID_ORDERS);
            }

            bulkUpdateResponse.setInvalidOrders(validatedOrders.getInvalidOrders());
        }
        return new ResponseEntity<BaseResponseBean>(bulkUpdateResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/downloadSampleExcel", method = RequestMethod.GET)
    @ResponseBody
    public void exportExcel(HttpServletResponse response) throws IOException
    {
        PSOLoggerSrv.printDEBUG("UpdateOrderController", "exportExcel", null);
        
        String fileName = PSOConstants.UPDATE_STATUS_EXCEL;
//        if (orderType.equalsIgnoreCase(PSOConstants.STATUS))
//        {
//            fileName = PSOConstants.UPDATE_STATUS_EXCEL;
//        }
//        else if (orderType.equalsIgnoreCase(PSOConstants.SIM))
//        {
//            fileName = PSOConstants.UPDATE_SIM_EXCEL;
//        }
//        else if (orderType.equalsIgnoreCase(PSOConstants.IMEI))
//        {
//            fileName = PSOConstants.UPDATE_IMEI_EXCEL;
//        }
//        else if (orderType.equalsIgnoreCase(PSOConstants.RETRY_COUNT))
//        {
//            fileName = PSOConstants.UPDATE_RETRY_EXCEL;
//        }

        InputStream inputStream = null;
        
        try
        {
            
            fileName = "BULK_UPDATE.xlsx";
            File file = null;
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            file = new File(classloader.getResource("sampleExcels/" + fileName).getFile());

            if (!file.exists())
            {
                String errorMessage = "Sorry. The file you are looking for does not exist";
                System.out.println(errorMessage);
                OutputStream outputStream = response.getOutputStream();
                outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
                outputStream.close();
                return;
            }

            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            if (mimeType == null)
            {
                mimeType = PSOConstants.EXCEL_CONT_TYPE;
            }

            response.setContentType(mimeType);

            /*
             * "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser while others(zip e.g) will be directly downloaded [may provide
             * save as popup, based on your browser setting.]
             */
            response.setHeader(PSOConstants.CONTENT_DISPOSITION, String.format("inline; filename=\"" + file.getName() + "\""));

            /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting */
            // response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));

            response.setContentLength((int) file.length());

            inputStream = new BufferedInputStream(new FileInputStream(file));

            // Copy bytes from source to destination(outputstream in this example), closes both streams.
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("UpdateOrderController", "exportExcel", e);
        }
        finally
        {
            if(null!=inputStream)
            {
                inputStream.close();
            }
        }

    }
    
    @RequestMapping(value = "/getAllowedUpdates", method = RequestMethod.POST)
    public ResponseEntity<AllowedUpdatesResponseBean> getAllowedUpdates(HttpServletRequest request, @RequestParam Map<String, Object> params)
    {
        PSOLoggerSrv.printDEBUG("UpdateOrderController", "getAllowedUpdates", null);

        AllowedUpdatesResponseBean allowdedUpdatelist = new AllowedUpdatesResponseBean();
        allowdedUpdatelist = updateService.getAllowdedUpdates();
        return new ResponseEntity<AllowedUpdatesResponseBean>(allowdedUpdatelist, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/updateMultiOrderDetails", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean> updateMultiOrderDetails(@RequestBody UpdateMultiOrderDetailsRequestBean updateOrderRequest)
    {
        updateService.updateMultiOrderDetails(updateOrderRequest);
        return new ResponseEntity<BaseResponseBean>(new BaseResponseBean(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/updateBulkOrderDetails/{bulkUpdateId}", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean> updateBulkOrderDetails(HttpServletRequest request, @RequestParam Map<String, Object> params, @PathVariable("bulkUpdateId") String bulkUpdateId)
    {
    	BaseResponseBean resp =  new BaseResponseBean();
    	resp = updateService.updateBulkOrderDetails(bulkUpdateId);
        return new ResponseEntity<BaseResponseBean>(resp, HttpStatus.OK);
    }
    
}
