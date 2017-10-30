/************************************************************************************************************
 * Class Name :  RejectPendingUserRequest.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Oct 29, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
public class RejectPendingUserRequest implements Serializable
{
    private static final long serialVersionUID = 6128658710315519227L;
    private String empId;
    private String rejectComments;
    
    /**
     * 
     */
    public RejectPendingUserRequest()
    {
        super();
    }
    
    /**
     * @param empId
     * @param rejectComments
     */
    public RejectPendingUserRequest(String empId, String rejectComments)
    {
        super();
        this.empId = empId;
        this.rejectComments = rejectComments;
    }
    
    /**
     * @return the empId
     */
    public String getEmpId()
    {
        return empId;
    }
    
    /**
     * @param empId the empId to set
     */
    public void setEmpId(String empId)
    {
        this.empId = empId;
    }
    
    /**
     * @return the rejectComments
     */
    public String getRejectComments()
    {
        return rejectComments;
    }
    
    /**
     * @param rejectComments the rejectComments to set
     */
    public void setRejectComments(String rejectComments)
    {
        this.rejectComments = rejectComments;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((empId == null) ? 0 : empId.hashCode());
        result = prime * result + ((rejectComments == null) ? 0 : rejectComments.hashCode());
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
        RejectPendingUserRequest other = (RejectPendingUserRequest) obj;
        if (empId == null)
        {
            if (other.empId != null)
                return false;
        }
        else if (!empId.equals(other.empId))
            return false;
        if (rejectComments == null)
        {
            if (other.rejectComments != null)
                return false;
        }
        else if (!rejectComments.equals(other.rejectComments))
            return false;
        return true;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "RejectPendingUserRequest [empId=" + empId + ", rejectComments=" + rejectComments + "]";
    }
    
    
    
    
}
