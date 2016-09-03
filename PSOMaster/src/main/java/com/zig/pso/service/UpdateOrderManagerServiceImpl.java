/************************************************************************************************************
 * Class Name : UpdateOrderManagerServiceImpl.java 
 * Description:
 * Author : Ankita Mishra 
 * Date : Aug 1, 2016 
 * **********************************************************************************************************
 */
package com.zig.pso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.dao.UpdateOrderManagerDAO;
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.UpdateOrderRequestBean;

/**
 * 
 */
@Service
public class UpdateOrderManagerServiceImpl implements UpdateOrderManagerService
{

    @Autowired
    UpdateOrderManagerDAO updateDAO;

    /*
     * (non-Javadoc)
     * @see com.zig.pso.service.UpdateOrderManagerService#updateSingleOrderData(com.zig.pso.rest.bean.UpdateOrderRequestBean)
     */
    @Override
    public BaseResponseBean updateSingleOrderData(UpdateOrderRequestBean updateOrderRequest)
    {
        if (updateOrderRequest.getType().equalsIgnoreCase("status"))
        {
        	BaseResponseBean updateOrderRes = new BaseResponseBean();
        	String value = updateOrderRequest.getNewValue();
        	if(value.length()==4)
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
            if(value.length()==21 && isNumeric)
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
        	if(value.length()==16 && isNumeric)
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
            if(value>0 && value<10)
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

}
