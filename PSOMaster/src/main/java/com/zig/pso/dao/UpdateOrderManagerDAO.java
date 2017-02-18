/************************************************************************************************************
 * Class Name : UpdateOrderManagerDAO.java 
 * Description:
 * 
 * Author : Ankita Mishra 
 * Date : Aug 1, 2016 
 * **********************************************************************************************************
 */
package com.zig.pso.dao;

import java.util.ArrayList;

import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.OrderUpdateInputData;
import com.zig.pso.rest.bean.TempInsertBUResponse;
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

    public BaseResponseBean updateBulkOrderStatus(ArrayList<OrderUpdateInputData> orderUpdateData);

    public BaseResponseBean updateBulkOrderSim(ArrayList<OrderUpdateInputData> orderUpdateData);

    public BaseResponseBean updateBulkOrderImei(ArrayList<OrderUpdateInputData> orderUpdateData);

    public BaseResponseBean updateBulkOrderRetryCount(ArrayList<OrderUpdateInputData> orderUpdateData);
    
    public TempInsertBUResponse insertBulkOrderDataInTempTable(ArrayList<OrderUpdateInputData> orderUpdateData,String updateType);
    
    public ArrayList<OrderUpdateInputData> getBulkOrderDataFromTempTable(String tempTableName);

}
