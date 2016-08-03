/************************************************************************************************************
 * Class Name : UpdateOrderManagerService.java Description:
 * 
 * Author : Ankita Mishra Date : Aug 1, 2016 **********************************************************************************************************
 */
package com.zig.pso.service;

import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.UpdateOrderRequestBean;

/**
 * 
 */

public interface UpdateOrderManagerService
{

    public BaseResponseBean updateSingleOrderData(UpdateOrderRequestBean updateOrderRequest);
}
