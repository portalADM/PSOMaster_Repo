/************************************************************************************************************
 * Class Name : OrderInfoManagerService.java Description: This interface contains methods for order related operations.
 * 
 * Author : Ankita Mishra Date : Jun 26, 2016 **********************************************************************************************************
 */
package com.zig.pso.service;

import java.util.ArrayList;

import com.zig.pso.rest.bean.EnsOrderMasterResponseBean;
import com.zig.pso.rest.bean.PortalOrderMasterResponseBean;

public interface OrderInfoManagerService
{
    public ArrayList<String> getOrderIds();

    /**
     * @param OrderId
     * @return
     */
    public PortalOrderMasterResponseBean getPortalOrderDataInfo(String OrderId);

    /**
     * @param OrderId
     * @return
     */
    public EnsOrderMasterResponseBean getEnsOrderDataInfo(String OrderId);
}
