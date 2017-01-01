/************************************************************************************************************
 * Class Name :  OrderPortInDetailsResponseBean.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Dec 31, 2016
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.util.List;

/**
 * 
 */
public class OrderPortInDetailsResponseBean extends BaseResponseBean 
{
    private List<PortalOrderPortRequestBean> portalPortReqDetailsList;
    
    private List<EnsOrderPortRequestBean> ensPortReqDetailsList;

    /**
     * @return the portalPortReqDetailsList
     */
    public List<PortalOrderPortRequestBean> getPortalPortReqDetailsList()
    {
        return portalPortReqDetailsList;
    }

    /**
     * @param portalPortReqDetailsList the portalPortReqDetailsList to set
     */
    public void setPortalPortReqDetailsList(List<PortalOrderPortRequestBean> portalPortReqDetailsList)
    {
        this.portalPortReqDetailsList = portalPortReqDetailsList;
    }

    /**
     * @return the ensPortReqDetailsList
     */
    public List<EnsOrderPortRequestBean> getEnsPortReqDetailsList()
    {
        return ensPortReqDetailsList;
    }

    /**
     * @param ensPortReqDetailsList the ensPortReqDetailsList to set
     */
    public void setEnsPortReqDetailsList(List<EnsOrderPortRequestBean> ensPortReqDetailsList)
    {
        this.ensPortReqDetailsList = ensPortReqDetailsList;
    }
    
    
}
