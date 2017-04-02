/************************************************************************************************************
 * Class Name :  UpdateMultiOrderDetailsRequestBean.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Mar 28, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 
 */
public class UpdateMultiOrderDetailsRequestBean implements Serializable
{
    private static final long serialVersionUID = 7230428735846923337L;
    
    private String orderId;
    private String tabName;
    private List<ColumnDataListBean> colData;
    private boolean isLineLevelUpdate;
    
    
    
    /**
     * 
     */
    public UpdateMultiOrderDetailsRequestBean()
    {
        super();
    }



    /**
     * @param orderId
     * @param tabName
     * @param colData
     * @param isLineLevelUpdate
     */
    public UpdateMultiOrderDetailsRequestBean(String orderId, String tabName, List<ColumnDataListBean> colData, boolean isLineLevelUpdate)
    {
        super();
        this.orderId = orderId;
        this.tabName = tabName;
        this.colData = colData;
        this.isLineLevelUpdate = isLineLevelUpdate;
    }



    /**
     * @return the orderId
     */
    public String getOrderId()
    {
        return orderId;
    }



    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }



    /**
     * @return the tabName
     */
    public String getTabName()
    {
        return tabName;
    }



    /**
     * @param tabName the tabName to set
     */
    public void setTabName(String tabName)
    {
        this.tabName = tabName;
    }



    /**
     * @return the colData
     */
    public List<ColumnDataListBean> getColData()
    {
        return colData;
    }



    /**
     * @param colData the colData to set
     */
    public void setColData(List<ColumnDataListBean> colData)
    {
        this.colData = colData;
    }



    /**
     * @return the isLineLevelUpdate
     */
    public boolean isLineLevelUpdate()
    {
        return isLineLevelUpdate;
    }



    /**
     * @param isLineLevelUpdate the isLineLevelUpdate to set
     */
    public void setLineLevelUpdate(boolean isLineLevelUpdate)
    {
        this.isLineLevelUpdate = isLineLevelUpdate;
    }



    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((colData == null) ? 0 : colData.hashCode());
        result = prime * result + (isLineLevelUpdate ? 1231 : 1237);
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        result = prime * result + ((tabName == null) ? 0 : tabName.hashCode());
        return result;
    }



    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UpdateMultiOrderDetailsRequestBean other = (UpdateMultiOrderDetailsRequestBean) obj;
        if (colData == null)
        {
            if (other.colData != null)
                return false;
        }
        else if (!colData.equals(other.colData))
            return false;
        if (isLineLevelUpdate != other.isLineLevelUpdate)
            return false;
        if (orderId == null)
        {
            if (other.orderId != null)
                return false;
        }
        else if (!orderId.equals(other.orderId))
            return false;
        if (tabName == null)
        {
            if (other.tabName != null)
                return false;
        }
        else if (!tabName.equals(other.tabName))
            return false;
        return true;
    }



    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "UpdateMultiOrderDetailsRequestBean [orderId=" + orderId + ", tabName=" + tabName + ", colData=" + colData + ", isLineLevelUpdate=" + isLineLevelUpdate + "]";
    }


}
