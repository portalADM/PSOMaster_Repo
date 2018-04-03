/************************************************************************************************************
 * Class Name : UpdateOrderManagerDAO.java 
 * Description:
 * 
 * Author : Ankita Mishra 
 * Date : Aug 1, 2016 
 * **********************************************************************************************************
 */
package com.zig.pso.dao;

import java.util.List;

import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.OrderUpdateInputData;
import com.zig.pso.rest.bean.TempInsertBUResponse;
import com.zig.pso.rest.bean.UpdateMultiOrderDetailsRequestBean;
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

    public BaseResponseBean updateBulkOrderStatus(List<OrderUpdateInputData> orderUpdateData);

    public BaseResponseBean updateBulkOrderSim(List<OrderUpdateInputData> orderUpdateData);

    public BaseResponseBean updateBulkOrderImei(List<OrderUpdateInputData> orderUpdateData);

    public BaseResponseBean updateBulkOrderRetryCount(List<OrderUpdateInputData> orderUpdateData);
    
    public TempInsertBUResponse insertBulkOrderDataInTempTable(List<OrderUpdateInputData> orderUpdateData,String updateMadeByUser);
    
    public List<OrderUpdateInputData> getBulkOrderDataFromTempTable(String bulkUpdateId);
    
    public BaseResponseBean updateMultiOrderDetails(UpdateMultiOrderDetailsRequestBean updateOrderRequest);
    
    public BaseResponseBean updateBulkOrderDetails(String bulkUpdateId,String updateMadeByUser);

}
