/************************************************************************************************************
 * Class Name : UpdateOrderManagerDAO.java Description:
 * 
 * Author : Ankita Mishra Date : Aug 1, 2016 **********************************************************************************************************
 */
package com.zig.pso.dao;

import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.UpdateOrderRequestBean;

/**
 * 
 */
public interface UpdateOrderManagerDAO
{

    public BaseResponseBean updateOrderStatus(UpdateOrderRequestBean updateOrderRequest);

    public BaseResponseBean updateOrderSim(UpdateOrderRequestBean updateOrderRequest);

    public BaseResponseBean updateOrderImei(UpdateOrderRequestBean updateOrderRequest);

    public BaseResponseBean updateOrderRetryCount(UpdateOrderRequestBean updateOrderRequest);

}
