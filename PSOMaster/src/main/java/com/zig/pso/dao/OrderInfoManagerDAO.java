/************************************************************************************************************
 * Class Name : OrderInfoManagerDAO.java 
 * Description: This interface provides methods for order related operations. 
 * Author : Nilesh Patil 
 * Date : Jun 26, 2016 
 * **********************************************************************************************************
 */
package com.zig.pso.dao;

import java.util.ArrayList;

import com.zig.pso.rest.bean.ApiOrderMasterResponseBean;
import com.zig.pso.rest.bean.EnsOrderMasterResponseBean;
import com.zig.pso.rest.bean.PortalEnrollmentInfo;
import com.zig.pso.rest.bean.PortalOrderMasterResponseBean;
import com.zig.pso.rest.bean.PortalShipmentInfo;

/**
 * 
 */
public interface OrderInfoManagerDAO
{
    public ArrayList<String> getOrderIds();

    public PortalOrderMasterResponseBean getPortalDataInfo(String OrderId);

    /**
     * @param orderId
     * @return
     */
    public EnsOrderMasterResponseBean getEnsembleDataInfo(String orderId);

    public ApiOrderMasterResponseBean getAPIDataInfo(String orderId);

    public ArrayList<PortalShipmentInfo> getPortalShipmentInfoFromDB(String orderId);

    public String getAPIRequestBody(String seq_number);

    public PortalOrderMasterResponseBean getZigAutoMasterData(String orderId);

    public PortalEnrollmentInfo getOrderEnrollmentInfo(String orderId);

    public PortalOrderMasterResponseBean getCustomerBANandCTN(String orderId);

    public String getOrderTypeFromExtraOrder(String orderId);
}
