/************************************************************************************************************
 * Class Name : UpdateOrderManagerServiceImpl.java 
 * Description: 
 * Author : Ankita Mishra 
 * Date : Aug 1, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.dao.UpdateOrderManagerDAO;
import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.AllowedUpdatesResponseBean;
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.BulkUpdateInputBean;
import com.zig.pso.rest.bean.OrderUpdateInputData;
import com.zig.pso.rest.bean.TempInsertBUResponse;
import com.zig.pso.rest.bean.UpdateOrderRequestBean;
import com.zig.pso.rest.bean.ValidatedBulkUpdateOrderDetailsBean;
import com.zig.pso.utility.PropertyReader;

/**
 * 
 */
@Service
public class UpdateOrderManagerServiceImpl implements UpdateOrderManagerService
{

    @Autowired
    UpdateOrderManagerDAO updateDAO;

    private static final String SIM = "sim";
    private static final String IMEI = "imei";
    private static final String STATUS = "status";
    private static final String RETRY_COUNT = "retry";

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.UpdateOrderManagerService#updateSingleOrderData(com.zig.pso.rest.bean.UpdateOrderRequestBean)
     */
    @Override
    public BaseResponseBean updateSingleOrderData(UpdateOrderRequestBean updateOrderRequest)
    {
        PSOLoggerSrv.printDEBUG("UpdateOrderManagerServiceImpl", "updateSingleOrderData","");
        
        if (updateOrderRequest.getType().equalsIgnoreCase(STATUS))
        {
            BaseResponseBean updateOrderRes = new BaseResponseBean();
            String value = updateOrderRequest.getNewValue();
            if (value.length() == 4)
            {
                updateOrderRes = updateDAO.updateOrderStatus(updateOrderRequest);
            }
            else
            {
                updateOrderRes.setErrorCode(PSOConstants.ERROR_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.INVALID_STATUS_CODE);
            }
            return updateOrderRes;
        }
        else if (updateOrderRequest.getType().equalsIgnoreCase(SIM))
        {
            BaseResponseBean updateOrderRes = new BaseResponseBean();
            String value = updateOrderRequest.getNewValue();
            String regex = "[0-9]+";
            Boolean isNumeric = value.matches(regex);
            System.out.println(value.length());
            if (value.length() == 19 && isNumeric)
            {
                updateOrderRes = updateDAO.updateOrderSim(updateOrderRequest);
            }
            else
            {
                updateOrderRes.setErrorCode(PSOConstants.ERROR_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.INVALID_SIM);
            }
            return updateOrderRes;
        }
        else if (updateOrderRequest.getType().equalsIgnoreCase(IMEI))
        {
            BaseResponseBean updateOrderRes = new BaseResponseBean();
            String value = updateOrderRequest.getNewValue();
            String regex = "[0-9]+";
            Boolean isNumeric = value.matches(regex);
            if (value.length() == 15 && isNumeric)
            {
                updateOrderRes = updateDAO.updateOrderImei(updateOrderRequest);
            }
            else
            {
                updateOrderRes.setErrorCode(PSOConstants.ERROR_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.INVALID_IMEI);
            }
            return updateOrderRes;
        }
        else if (updateOrderRequest.getType().equalsIgnoreCase(RETRY_COUNT))
        {
            BaseResponseBean updateOrderRes = new BaseResponseBean();
            int value = Integer.parseInt(updateOrderRequest.getNewValue());
            if (value > 0 && value < 10)
            {
                updateOrderRes = updateDAO.updateOrderRetryCount(updateOrderRequest);
            }
            else
            {
                updateOrderRes.setErrorCode(PSOConstants.ERROR_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.INVALID_RETYR_COUNT);
            }
            return updateOrderRes;
        }

        return null;
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.UpdateOrderManagerService#updateBulkOrderData(com.zig.pso.rest.bean.BulkUpdateInputBean)
     */
    @Override
    public BaseResponseBean updateBulkOrderStatus(ArrayList<OrderUpdateInputData> orderUpdateData)
    {
        PSOLoggerSrv.printDEBUG("UpdateOrderManagerServiceImpl", "updateBulkOrderStatus", "Number of Orders to update: "+orderUpdateData.size());
        return updateDAO.updateBulkOrderStatus(orderUpdateData);
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.UpdateOrderManagerService#updateBulkOrderSim(com.zig.pso.rest.bean.BulkUpdateInputBean)
     */
    @Override
    public BaseResponseBean updateBulkOrderSim(ArrayList<OrderUpdateInputData> orderUpdateData)
    {
        PSOLoggerSrv.printDEBUG("UpdateOrderManagerServiceImpl", "updateBulkOrderSim", "Number of Orders to update: "+orderUpdateData.size());
        return updateDAO.updateBulkOrderSim(orderUpdateData);
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.UpdateOrderManagerService#updateBulkOrderImei(com.zig.pso.rest.bean.BulkUpdateInputBean)
     */
    @Override
    public BaseResponseBean updateBulkOrderImei(ArrayList<OrderUpdateInputData> orderUpdateData)
    {
        PSOLoggerSrv.printDEBUG("UpdateOrderManagerServiceImpl", "updateBulkOrderImei", "Number of Orders to update: "+orderUpdateData.size());
        return updateDAO.updateBulkOrderImei(orderUpdateData);
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.UpdateOrderManagerService#updateBulkOrderRetryCount(com.zig.pso.rest.bean.BulkUpdateInputBean)
     */
    @Override
    public BaseResponseBean updateBulkOrderRetryCount(ArrayList<OrderUpdateInputData> orderUpdateData)
    {
        PSOLoggerSrv.printDEBUG("UpdateOrderManagerServiceImpl", "updateBulkOrderRetryCount", "Number of Orders to update: "+orderUpdateData.size());
        return updateDAO.updateBulkOrderRetryCount(orderUpdateData);
    }

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.UpdateOrderManagerService#getUploadedFileData(org.springframework.web.multipart.MultipartFile)
     */
    @Override
    public BulkUpdateInputBean getUploadedFileData(MultipartFile file, String updateType)
    {
        PSOLoggerSrv.printDEBUG("UpdateOrderManagerServiceImpl", "getUploadedFileData", "updateType: "+ updateType);
        BulkUpdateInputBean orderBulkData = new BulkUpdateInputBean();
        ArrayList<OrderUpdateInputData> orderUpdateData = new ArrayList<OrderUpdateInputData>();

        try
        {
            int i = 1;
            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
            XSSFSheet worksheet = workbook.getSheetAt(0);
            while (i <= worksheet.getLastRowNum())
            {
                XSSFRow row = worksheet.getRow(i++);
                OrderUpdateInputData order = new OrderUpdateInputData();
                Iterator cells = row.cellIterator();

                int colNum = 0;
                while (cells.hasNext())
                {
                    Cell cell = (Cell) cells.next();
                    cell.setCellType(Cell.CELL_TYPE_STRING);

                    if (colNum == 0)
                        order.setOrderId(cell.getStringCellValue());
                    else
                    {
                        if (updateType.equalsIgnoreCase(STATUS))
                        {
                            order.setStatus(cell.getStringCellValue());
                        }
                        else if (updateType.equalsIgnoreCase(SIM))
                        {
                            order.setSim(cell.getStringCellValue());
                        }
                        else if (updateType.equalsIgnoreCase(IMEI))
                        {
                            order.setImei(cell.getStringCellValue());
                        }
                        else if (updateType.equalsIgnoreCase(RETRY_COUNT))
                        {
                            order.setRetryCount(cell.getStringCellValue());
                        }
                        colNum = 0;
                    }
                    colNum++;
                }
                orderUpdateData.add(order);
            }
            orderBulkData.setOrderUpdateData(orderUpdateData);
            orderBulkData.setUpdateType(updateType);
            workbook.close();

        }
        catch (Exception e)
        {
            PSOLoggerSrv.printERROR("UpdateOrderManagerServiceImpl", "getUploadedFileData", e);
        }

        return orderBulkData;
    }

    @Override
    public ValidatedBulkUpdateOrderDetailsBean validateUploadedData(BulkUpdateInputBean orderBulkData)
    {
        PSOLoggerSrv.printDEBUG("UpdateOrderManagerServiceImpl", "validateUploadedData", "");
        
        ValidatedBulkUpdateOrderDetailsBean validatedOrderData = new ValidatedBulkUpdateOrderDetailsBean();
        List<String> invalidOrderIDs = new ArrayList<String>();
        ArrayList<OrderUpdateInputData> validOerderData = new ArrayList<OrderUpdateInputData>();
        String numOnlyRegex = "[0-9]+";
        String charOnlyRegex = "[a-zA-Z]+";

        boolean isValidOrder = true;

        for (OrderUpdateInputData orders : orderBulkData.getOrderUpdateData())
        {
            if (STATUS.equals(orderBulkData.getUpdateType()) && (null == orders.getStatus() || !orders.getStatus().matches(charOnlyRegex) || orders.getStatus().length() != 4))
            {
                isValidOrder = false;
            }
            else if (SIM.equals(orderBulkData.getUpdateType()) && (null == orders.getSim() || !orders.getSim().matches(numOnlyRegex) || orders.getSim().length() != 21))
            {
                isValidOrder = false;
            }
            else if (IMEI.equals(orderBulkData.getUpdateType()) && (null == orders.getImei() || !orders.getImei().matches(numOnlyRegex) || orders.getImei().length() != 16))
            {
                isValidOrder = false;
            }
            else if (RETRY_COUNT.equals(orderBulkData.getUpdateType()) && (null == orders.getRetryCount() || !orders.getRetryCount().matches(numOnlyRegex) || orders.getRetryCount().length() != 1))
            {
                isValidOrder = false;
            }

            if (isValidOrder)
                validOerderData.add(orders);
            else
                invalidOrderIDs.add(orders.getOrderId());

            isValidOrder = true;
        }

        String debugMsg = "Num of Valid Orders : "+validOerderData.size()+" \nNum of Invalid Orders : "+invalidOrderIDs.size();
        PSOLoggerSrv.printDEBUG("UpdateOrderManagerServiceImpl", "validateUploadedData", debugMsg);
        
        validatedOrderData.setInvalidOrders(invalidOrderIDs);
        
        
        /* Insert Valid records in to temporary table for further Bulk update process */
        TempInsertBUResponse insertTempDataResp = updateDAO.insertBulkOrderDataInTempTable(validOerderData, orderBulkData.getUpdateType());
        if(insertTempDataResp.getErrorCode() == PSOConstants.SUCCESS_CODE)
        {
            ArrayList<OrderUpdateInputData> tempTableDataList = updateDAO.getBulkOrderDataFromTempTable(insertTempDataResp.getTempTableName());
            validatedOrderData.setOrderUpdateData(tempTableDataList);
        }
        
        return validatedOrderData;
    }

	/* (non-Javadoc)
	 * @see com.zig.pso.service.UpdateOrderManagerService#getAllowdedUpdates()
	 */
	@Override
	public AllowedUpdatesResponseBean getAllowdedUpdates() {
		
		PSOLoggerSrv.printDEBUG("UpdateOrderManagerServiceImpl", "getAllowdedUpdates", "");
		
		AllowedUpdatesResponseBean  updatesList = new AllowedUpdatesResponseBean(); 
		
		String availableUpdates = PropertyReader.getAdminProperties().getProperty("availableUpdates");
		String restrictedUpdates = PropertyReader.getAdminProperties().getProperty("restrictedUpdates");
		
		if(availableUpdates!=null)
			updatesList.setAvailableUpdates(Arrays.asList(availableUpdates.split(",")));
		
		if(restrictedUpdates!=null)
			updatesList.setRestrictedUpdates(Arrays.asList(restrictedUpdates.split(",")));
		
		
		return updatesList;

	}
}
