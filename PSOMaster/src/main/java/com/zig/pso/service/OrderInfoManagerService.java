/************************************************************************************************************
 * Class Name : OrderInfoManagerService.java 
 * Description: This interface contains methods for order related operations. 
 * Author : Ankita Mishra 
 * Date : Jun 26, 2016 
 * **********************************************************************************************************
 */
package com.zig.pso.service;

import java.util.ArrayList;

import com.zig.pso.rest.bean.ApiOrderMasterResponseBean;
import com.zig.pso.rest.bean.EnsOrderMasterResponseBean;
import com.zig.pso.rest.bean.OrderPortInDetailsResponseBean;
import com.zig.pso.rest.bean.PortalOrderLineSIMandIMEIDetailsBean;
import com.zig.pso.rest.bean.PortalOrderMasterResponseBean;
import com.zig.pso.rest.bean.PortalShipmentInfoForUI;

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

    /**
     * @param OrderId
     * @return
     */
    public ApiOrderMasterResponseBean getAPIOrderDataInfo(String OrderId);

    /**
     * @param OrderId
     * @return
     */
    public PortalShipmentInfoForUI getPortalShipmentInfo(String OrderId);

    /**
     * @param seq_number
     * @return String
     */
    public String getAPIRequestResponseBody(String seq_number,String callType);
    
    /**
     * @param OrderId
     * @return
     */
    public OrderPortInDetailsResponseBean getPortalOrderPortDetails(String OrderId);
    
    public PortalOrderLineSIMandIMEIDetailsBean getPortalLineSimAndImeiDetails(String OrderId);
}
