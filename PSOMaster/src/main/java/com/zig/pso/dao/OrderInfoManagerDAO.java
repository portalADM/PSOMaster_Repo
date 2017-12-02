/************************************************************************************************************
 * Class Name : OrderInfoManagerDAO.java 
 * Description: This interface provides methods for order related operations. 
 * Author : Nilesh Patil 
 * Date : Jun 26, 2016 
  --------------------------------
 * Modified by : Pankaj Chaudhary
 * Date : Nov 21, 2017 
 * **********************************************************************************************************
 */
package com.zig.pso.dao;

import java.util.List;

import com.zig.pso.rest.bean.ApiOrderMasterResponseBean;
import com.zig.pso.rest.bean.EnsOrderMasterResponseBean;
import com.zig.pso.rest.bean.EnsOrderPortRequestBean;
import com.zig.pso.rest.bean.EnsembleLineItemInfoBean;
import com.zig.pso.rest.bean.InventoryStatusofItemBean;
import com.zig.pso.rest.bean.NameDataBean;
import com.zig.pso.rest.bean.PortalEnrollmentInfo;
import com.zig.pso.rest.bean.PortalLineItemInfoBean;
import com.zig.pso.rest.bean.PortalOrderMasterResponseBean;
import com.zig.pso.rest.bean.PortalOrderPortRequestBean;
import com.zig.pso.rest.bean.PortalShipmentInfo;

/**
 * 
 */
public interface OrderInfoManagerDAO
{
    public List<String> getOrderIds();

    public PortalOrderMasterResponseBean getPortalDataInfo(String OrderId);

    public EnsOrderMasterResponseBean getEnsembleDataInfo(String orderId);

    public ApiOrderMasterResponseBean getAPIDataInfo(String orderId);

    public List<PortalShipmentInfo> getPortalShipmentInfoFromDB(String orderId);

    public String getAPIRequestResponseBody(String seq_number,String callType);

    public PortalOrderMasterResponseBean getZigAutoMasterData(String orderId);

    public PortalEnrollmentInfo getOrderEnrollmentInfo(String orderId);

    public PortalOrderMasterResponseBean getCustomerBANandCTN(String orderId);
    
    public InventoryStatusofItemBean getInventoryStatus(String skuId);
    
    public NameDataBean getESNReuseData(String esn);

    public String getOrderTypeFromExtraOrder(String orderId);
    
    public List<PortalLineItemInfoBean> getPortalLineItemInfo(String orderId);
    
    public List<EnsembleLineItemInfoBean> getEnsLineItemInfo(String orderId);
    
    public List<PortalOrderPortRequestBean> getPortalOrderPortDetails(String orderId);
    
    public List<EnsOrderPortRequestBean> getEnsOrderPortDetails(String orderId);
    
    public List<PortalShipmentInfo>  getPortalLineSimAndImeiDetails(String orderId);
    
    public String getOrderCurrentValue(String orderId,String lineId,String updateType);
    
    public List<String> getOrderStatusList();
}
