/************************************************************************************************************
 * Class Name : UpdateOrderController.java Description:
 * 
 * Author : Ankita Mishra Date : Aug 1, 2016 **********************************************************************************************************
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
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.BulkUpdateInputBean;
import com.zig.pso.rest.bean.BulkUpdateOrderResponseBean;
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

        PSOLoggerSrv.printINFO("############### updateOrder Rest ###########################");

        BaseResponseBean nameList = new BaseResponseBean();
        nameList = updateService.updateSingleOrderData(updateOrderRequest);
        return new ResponseEntity<BaseResponseBean>(nameList, HttpStatus.OK);
    }

    @RequestMapping(value = "/upload/{updateType}", method = RequestMethod.POST)
    public ResponseEntity<BaseResponseBean> uploadFile(HttpServletRequest request, @RequestParam Map<String, Object> params, @PathVariable("updateType") String updateType)
    {
        BulkUpdateOrderResponseBean bulkUpdateResponse = new BulkUpdateOrderResponseBean();
        if (request instanceof MultipartRequest)
        {
            BaseResponseBean response = new BaseResponseBean();
            MultipartFile file = ((MultipartRequest) request).getFile("file");

            BulkUpdateInputBean orderBulkData = updateService.getUploadedFileData(file, updateType);

            ValidatedBulkUpdateOrderDetailsBean validatedOrders = updateService.validateUploadedData(orderBulkData);

            if (updateType.equalsIgnoreCase(PSOConstants.STATUS))
            {
                response = updateService.updateBulkOrderStatus(validatedOrders.getValidOrderData());
            }
            else if (updateType.equalsIgnoreCase(PSOConstants.SIM))
            {
                response = updateService.updateBulkOrderSim(validatedOrders.getValidOrderData());
            }
            else if (updateType.equalsIgnoreCase(PSOConstants.IMEI))
            {
                response = updateService.updateBulkOrderImei(validatedOrders.getValidOrderData());
            }
            else if (updateType.equalsIgnoreCase(PSOConstants.RETRY_COUNT))
            {
                response = updateService.updateBulkOrderRetryCount(validatedOrders.getValidOrderData());
            }

            bulkUpdateResponse.setInvalidOrders(validatedOrders.getInvalidOrders());
            bulkUpdateResponse.setErrorCode(response.getErrorCode());
            bulkUpdateResponse.setErrorMsg(response.getErrorMsg());

        }
        return new ResponseEntity<BaseResponseBean>(bulkUpdateResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/downloadSampleExcel/{orderType}", method = RequestMethod.GET)
    @ResponseBody
    public void exportExcel(HttpServletResponse response, @PathVariable("orderType") String orderType) throws IOException
    {
        String fileName = PSOConstants.UPDATE_STATUS_EXCEL;
        if (orderType.equalsIgnoreCase(PSOConstants.STATUS))
        {
            fileName = PSOConstants.UPDATE_STATUS_EXCEL;
        }
        else if (orderType.equalsIgnoreCase(PSOConstants.SIM))
        {
            fileName = PSOConstants.UPDATE_SIM_EXCEL;
        }
        else if (orderType.equalsIgnoreCase(PSOConstants.IMEI))
        {
            fileName = PSOConstants.UPDATE_IMEI_EXCEL;
        }
        else if (orderType.equalsIgnoreCase(PSOConstants.RETRY_COUNT))
        {
            fileName = PSOConstants.UPDATE_RETRY_EXCEL;
        }

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

        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        // Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());

    }
}
