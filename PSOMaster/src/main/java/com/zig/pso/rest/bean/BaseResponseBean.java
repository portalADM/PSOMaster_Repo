/************************************************************************************************************
 * Class Name : BaseResponseBean.java 
 * Description: 
 * Author : Ankita Mishra 
 * Date : Jul 4, 2016 
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

/**
 * 
 */
public class BaseResponseBean
{
    private int errorCode;
    private String errorMsg;
    private String logRefId;

    public int getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(int errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getErrorMsg()
    {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }

    /**
     * @return the logRefId
     */
    public String getLogRefId()
    {
        return logRefId;
    }

    /**
     * @param logRefId the logRefId to set
     */
    public void setLogRefId(String logRefId)
    {
        this.logRefId = logRefId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + errorCode;
        result = prime * result + ((errorMsg == null) ? 0 : errorMsg.hashCode());
        result = prime * result + ((logRefId == null) ? 0 : logRefId.hashCode());
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
        BaseResponseBean other = (BaseResponseBean) obj;
        if (errorCode != other.errorCode)
            return false;
        if (errorMsg == null)
        {
            if (other.errorMsg != null)
                return false;
        }
        else if (!errorMsg.equals(other.errorMsg))
            return false;
        if (logRefId == null)
        {
            if (other.logRefId != null)
                return false;
        }
        else if (!logRefId.equals(other.logRefId))
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "BaseResponseBean [errorCode=" + errorCode + ", errorMsg=" + errorMsg + ", logRefId=" + logRefId + "]";
    }
    
    

}
