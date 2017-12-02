/************************************************************************************************************
 * Class Name :  PortalOrderLineSIMandIMEIDetailsBean.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Jan 28, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.util.List;

/**
 * 
 */
public class PortalOrderLineSIMandIMEIDetailsBean extends BaseResponseBean
{

    private List<PortalShipmentInfo> portalLineSimandImeiList;

    /**
     * 
     */
    public PortalOrderLineSIMandIMEIDetailsBean()
    {
        super();
    }

    /**
     * @param portalLineSimandImeiList
     */
    public PortalOrderLineSIMandIMEIDetailsBean(List<PortalShipmentInfo> portalLineSimandImeiList)
    {
        super();
        this.portalLineSimandImeiList = portalLineSimandImeiList;
    }

    /**
     * @return the portalLineSimandImeiList
     */
    public List<PortalShipmentInfo> getPortalLineSimandImeiList()
    {
        return portalLineSimandImeiList;
    }

    /**
     * @param portalLineSimandImeiList the portalLineSimandImeiList to set
     */
    public void setPortalLineSimandImeiList(List<PortalShipmentInfo> portalLineSimandImeiList)
    {
        this.portalLineSimandImeiList = portalLineSimandImeiList;
    }

}
