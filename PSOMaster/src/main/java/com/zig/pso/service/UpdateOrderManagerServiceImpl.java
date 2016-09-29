/************************************************************************************************************
 * Class Name : UpdateOrderManagerServiceImpl.java 
 * Description:
 * Author : Ankita Mishra 
 * Date : Aug 1, 2016 
 * **********************************************************************************************************
 */
package com.zig.pso.service;

import java.util.ArrayList;
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
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.BulkUpdateInputBean;
import com.zig.pso.rest.bean.OrderUpdateInputData;
import com.zig.pso.rest.bean.UpdateOrderRequestBean;
import com.zig.pso.rest.bean.ValidatedBulkUpdateOrderDetailsBean;

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
     * 
     * @see com.zig.pso.service.UpdateOrderManagerService#updateSingleOrderData(com.zig.pso.rest.bean.UpdateOrderRequestBean)
     */
    @Override
    public BaseResponseBean updateSingleOrderData(UpdateOrderRequestBean updateOrderRequest)
    {
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
                updateOrderRes.setErrorMsg(PSOConstants.Invalid_Status_Code);
            }
            return updateOrderRes;
        }
        else if (updateOrderRequest.getType().equalsIgnoreCase("sim"))
        {
            BaseResponseBean updateOrderRes = new BaseResponseBean();
            String value = updateOrderRequest.getNewValue();
            String regex = "[0-9]+";
            Boolean isNumeric = value.matches(regex);
            if (value.length() == 21 && isNumeric)
            {
                updateOrderRes = updateDAO.updateOrderSim(updateOrderRequest);
            }
            else
            {
                updateOrderRes.setErrorCode(PSOConstants.ERROR_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.Invalid_Sim_Number);
            }
            return updateOrderRes;
        }
        else if (updateOrderRequest.getType().equalsIgnoreCase("imei"))
        {
            BaseResponseBean updateOrderRes = new BaseResponseBean();
            String value = updateOrderRequest.getNewValue();
            String regex = "[0-9]+";
            Boolean isNumeric = value.matches(regex);
            if (value.length() == 16 && isNumeric)
            {
                updateOrderRes = updateDAO.updateOrderImei(updateOrderRequest);
            }
            else
            {
                updateOrderRes.setErrorCode(PSOConstants.ERROR_CODE);
                updateOrderRes.setErrorMsg(PSOConstants.Invalid_IMEI_Number);
            }
            return updateOrderRes;
        }
        else if (updateOrderRequest.getType().equalsIgnoreCase("retry"))
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
                updateOrderRes.setErrorMsg(PSOConstants.Invalid_Retry_Count);
            }
            return updateOrderRes;
        }

        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.service.UpdateOrderManagerService#updateBulkOrderData(com.zig.pso.rest.bean.BulkUpdateInputBean)
     */
    @Override
    public BaseResponseBean updateBulkOrderStatus(ArrayList<OrderUpdateInputData> orderUpdateData)
    {
        return updateDAO.updateBulkOrderStatus(orderUpdateData);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.service.UpdateOrderManagerService#updateBulkOrderSim(com.zig.pso.rest.bean.BulkUpdateInputBean)
     */
    @Override
    public BaseResponseBean updateBulkOrderSim(ArrayList<OrderUpdateInputData> orderUpdateData)
    {
        return updateDAO.updateBulkOrderSim(orderUpdateData);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.service.UpdateOrderManagerService#updateBulkOrderImei(com.zig.pso.rest.bean.BulkUpdateInputBean)
     */
    @Override
    public BaseResponseBean updateBulkOrderImei(ArrayList<OrderUpdateInputData> orderUpdateData)
    {
        return updateDAO.updateBulkOrderImei(orderUpdateData);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.service.UpdateOrderManagerService#updateBulkOrderRetryCount(com.zig.pso.rest.bean.BulkUpdateInputBean)
     */
    @Override
    public BaseResponseBean updateBulkOrderRetryCount(ArrayList<OrderUpdateInputData> orderUpdateData)
    {
        return updateDAO.updateBulkOrderRetryCount(orderUpdateData);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zig.pso.service.UpdateOrderManagerService#getUploadedFileData(org.springframework.web.multipart.MultipartFile)
     */
    @Override
    public BulkUpdateInputBean getUploadedFileData(MultipartFile file, String updateType)
    {
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
            e.printStackTrace();
        }

        return orderBulkData;
    }

    @Override
    public ValidatedBulkUpdateOrderDetailsBean validateUploadedData(BulkUpdateInputBean orderBulkData)
    {
        ValidatedBulkUpdateOrderDetailsBean validatedOrderData = new ValidatedBulkUpdateOrderDetailsBean();
        List<String> invalidOrderIDs = new ArrayList<String>();
        ArrayList<OrderUpdateInputData> validOerderData = new ArrayList<OrderUpdateInputData>();
        String numOnlyRegex = "[0-9]+";
        String charOnlyRegex = "[a-zA-Z]+";

        boolean isValidOrder = true;

        for (OrderUpdateInputData orders : orderBulkData.getOrderUpdateData())
        {
            if (STATUS.equals(orderBulkData.getUpdateType()) && (null == orders.getStatus() || !orders.getStatus().matches(charOnlyRegex) || orders.getSim().length() != 4))
            {
                isValidOrder = false;
                System.out.println("Not Matching " + orders.getOrderId());
            }
            else if (SIM.equals(orderBulkData.getUpdateType()) && (null == orders.getSim() || !orders.getSim().matches(numOnlyRegex) || orders.getSim().length() != 21))
            {
                isValidOrder = false;
                System.out.println("Not Matching " + orders.getOrderId());
            }
            else if (IMEI.equals(orderBulkData.getUpdateType()) && (null == orders.getImei() || !orders.getImei().matches(numOnlyRegex) || orders.getImei().length() != 16))
            {
                isValidOrder = false;
                System.out.println("Not Matching " + orders.getOrderId());
            }
            else if (RETRY_COUNT.equals(orderBulkData.getUpdateType()) && (null == orders.getRetryCount() || !orders.getRetryCount().matches(numOnlyRegex) || orders.getRetryCount().length() != 1))
            {
                isValidOrder = false;
                System.out.println("Not Matching " + orders.getOrderId());
            }

            if (isValidOrder)
                validOerderData.add(orders);
            else
                invalidOrderIDs.add(orders.getOrderId());

            isValidOrder = true;
        }

        validatedOrderData.setInvalidOrders(invalidOrderIDs);
        validatedOrderData.setOrderUpdateData(validOerderData);
        return validatedOrderData;
    }
}
