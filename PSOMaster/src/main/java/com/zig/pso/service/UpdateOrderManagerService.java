/************************************************************************************************************
 * Class Name : UpdateOrderManagerService.java Description:
 * Desc :
 * Author : Ankita Mishra 
 * Date : Aug 1, 2016 
 * **********************************************************************************************************
 */
package com.zig.pso.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import com.zig.pso.rest.bean.AllowedUpdatesResponseBean;
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.BulkUpdateInputBean;
import com.zig.pso.rest.bean.OrderUpdateInputData;
import com.zig.pso.rest.bean.UpdateOrderRequestBean;
import com.zig.pso.rest.bean.ValidatedBulkUpdateOrderDetailsBean;

/**
 * 
 */

public interface UpdateOrderManagerService
{

    public BaseResponseBean updateSingleOrderData(UpdateOrderRequestBean updateOrderRequest);

    public BaseResponseBean updateBulkOrderStatus(ArrayList<OrderUpdateInputData> orderUpdateData);

    public BaseResponseBean updateBulkOrderSim(ArrayList<OrderUpdateInputData> orderUpdateData);

    public BaseResponseBean updateBulkOrderImei(ArrayList<OrderUpdateInputData> orderUpdateData);

    public BaseResponseBean updateBulkOrderRetryCount(ArrayList<OrderUpdateInputData> orderUpdateData);

    public BulkUpdateInputBean getUploadedFileData(MultipartFile file, String updateType);

    public ValidatedBulkUpdateOrderDetailsBean validateUploadedData(BulkUpdateInputBean orderBulkData);
    
    public AllowedUpdatesResponseBean getAllowdedUpdates();
}
