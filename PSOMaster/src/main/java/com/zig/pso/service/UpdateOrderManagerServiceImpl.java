/************************************************************************************************************
 * Class Name : UpdateOrderManagerServiceImpl.java Description:
 * 
 * Author : Ankita Mishra Date : Aug 1, 2016 **********************************************************************************************************
 */
package com.zig.pso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            updateOrderRes = updateDAO.updateOrderStatus(updateOrderRequest);

            return updateOrderRes;

        }
        else if (updateOrderRequest.getType().equalsIgnoreCase("sim"))
        {
            BaseResponseBean updateOrderRes = new BaseResponseBean();
            updateOrderRes = updateDAO.updateOrderSim(updateOrderRequest);

            return updateOrderRes;

        }
        else if (updateOrderRequest.getType().equalsIgnoreCase("imei"))
        {
            BaseResponseBean updateOrderRes = new BaseResponseBean();
            updateOrderRes = updateDAO.updateOrderImei(updateOrderRequest);

            return updateOrderRes;

        }
        else if (updateOrderRequest.getType().equalsIgnoreCase("retry"))
        {
            BaseResponseBean updateOrderRes = new BaseResponseBean();
            updateOrderRes = updateDAO.updateOrderRetryCount(updateOrderRequest);

            return updateOrderRes;

        }

        return null;
    }

}
