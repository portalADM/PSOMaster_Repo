/************************************************************************************************************
 * Class Name : UpdateOrderManagerService.java Description:
 * 
 * Author : Ankita Mishra Date : Aug 1, 2016 **********************************************************************************************************
 */
package com.zig.pso.service;

import org.springframework.web.multipart.MultipartFile;

import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.BulkUpdateInputBean;
import com.zig.pso.rest.bean.UpdateOrderRequestBean;

/**
 * 
 */

public interface UpdateOrderManagerService
{

    public BaseResponseBean updateSingleOrderData(UpdateOrderRequestBean updateOrderRequest);

    public BaseResponseBean updateBulkOrderStatus(BulkUpdateInputBean updateOrderRequest);

    public BaseResponseBean updateBulkOrderSim(BulkUpdateInputBean updateOrderRequest);

    public BaseResponseBean updateBulkOrderImei(BulkUpdateInputBean updateOrderRequest);

    public BaseResponseBean updateBulkOrderRetryCount(BulkUpdateInputBean updateOrderRequest);

    public BulkUpdateInputBean getUploadedFileData(MultipartFile file, String updateType);
}
