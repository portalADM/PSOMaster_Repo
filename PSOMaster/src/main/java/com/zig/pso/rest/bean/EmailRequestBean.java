/************************************************************************************************************
 * Class Name : EmailRequestBean.java Description:
 * 
 * Author : Ankita Mishra Date : Oct 6, 2016 **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
public class EmailRequestBean implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1761003378500769205L;
    private String fromEmailId;
    private String toEmailIdList;
    private String ccEmailIdList;
    private String emailSubject;
    private String emailContent;

    @Override
    public String toString()
    {
        return "EmailRequestBean [fromEmailId=" + fromEmailId + ", toEmailIdList=" + toEmailIdList + ", ccEmailIdList=" + ccEmailIdList + ", emailSubject=" + emailSubject + ", emailContent="
                + emailContent + "]";
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ccEmailIdList == null) ? 0 : ccEmailIdList.hashCode());
        result = prime * result + ((emailContent == null) ? 0 : emailContent.hashCode());
        result = prime * result + ((emailSubject == null) ? 0 : emailSubject.hashCode());
        result = prime * result + ((fromEmailId == null) ? 0 : fromEmailId.hashCode());
        result = prime * result + ((toEmailIdList == null) ? 0 : toEmailIdList.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EmailRequestBean other = (EmailRequestBean) obj;
        if (ccEmailIdList == null)
        {
            if (other.ccEmailIdList != null)
                return false;
        }
        else if (!ccEmailIdList.equals(other.ccEmailIdList))
            return false;
        if (emailContent == null)
        {
            if (other.emailContent != null)
                return false;
        }
        else if (!emailContent.equals(other.emailContent))
            return false;
        if (emailSubject == null)
        {
            if (other.emailSubject != null)
                return false;
        }
        else if (!emailSubject.equals(other.emailSubject))
            return false;
        if (fromEmailId == null)
        {
            if (other.fromEmailId != null)
                return false;
        }
        else if (!fromEmailId.equals(other.fromEmailId))
            return false;
        if (toEmailIdList == null)
        {
            if (other.toEmailIdList != null)
                return false;
        }
        else if (!toEmailIdList.equals(other.toEmailIdList))
            return false;
        return true;
    }

    public String getFromEmailId()
    {
        return fromEmailId;
    }

    public void setFromEmailId(String fromEmailId)
    {
        this.fromEmailId = fromEmailId;
    }

    public String getToEmailIdList()
    {
        return toEmailIdList;
    }

    public void setToEmailIdList(String toEmailIdList)
    {
        this.toEmailIdList = toEmailIdList;
    }

    public String getCcEmailIdList()
    {
        return ccEmailIdList;
    }

    public void setCcEmailIdList(String ccEmailIdList)
    {
        this.ccEmailIdList = ccEmailIdList;
    }

    public String getEmailSubject()
    {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject)
    {
        this.emailSubject = emailSubject;
    }

    public String getEmailContent()
    {
        return emailContent;
    }

    public void setEmailContent(String emailContent)
    {
        this.emailContent = emailContent;
    }

}
