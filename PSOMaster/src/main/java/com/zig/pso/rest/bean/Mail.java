/************************************************************************************************************
 * Class Name :  Mail.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Nov 19, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.util.List;

/**
 * 
 */
public class Mail
{
    private String mailFrom;
    
    private List<String> mailTo;
 
    private List<String> mailCc;
 
    private List<String> mailBcc;
 
    private String mailSubject;
 
    private String mailContent;
 
    private String contentType;
 
    private List <Object> attachments;
 
    public Mail() {
        contentType = "text/html";
    }

    /**
     * @return the mailFrom
     */
    public String getMailFrom()
    {
        return mailFrom;
    }

    /**
     * @param mailFrom the mailFrom to set
     */
    public void setMailFrom(String mailFrom)
    {
        this.mailFrom = mailFrom;
    }

    /**
     * @return the mailTo
     */
    public List<String> getMailTo()
    {
        return mailTo;
    }

    /**
     * @param mailTo the mailTo to set
     */
    public void setMailTo(List<String> mailTo)
    {
        this.mailTo = mailTo;
    }

    /**
     * @return the mailCc
     */
    public List<String> getMailCc()
    {
        return mailCc;
    }

    /**
     * @param mailCc the mailCc to set
     */
    public void setMailCc(List<String> mailCc)
    {
        this.mailCc = mailCc;
    }

    /**
     * @return the mailBcc
     */
    public List<String> getMailBcc()
    {
        return mailBcc;
    }

    /**
     * @param mailBcc the mailBcc to set
     */
    public void setMailBcc(List<String> mailBcc)
    {
        this.mailBcc = mailBcc;
    }

    /**
     * @return the mailSubject
     */
    public String getMailSubject()
    {
        return mailSubject;
    }

    /**
     * @param mailSubject the mailSubject to set
     */
    public void setMailSubject(String mailSubject)
    {
        this.mailSubject = mailSubject;
    }

    /**
     * @return the mailContent
     */
    public String getMailContent()
    {
        return mailContent;
    }

    /**
     * @param mailContent the mailContent to set
     */
    public void setMailContent(String mailContent)
    {
        this.mailContent = mailContent;
    }

    /**
     * @return the contentType
     */
    public String getContentType()
    {
        return contentType;
    }

    /**
     * @param contentType the contentType to set
     */
    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }

    /**
     * @return the attachments
     */
    public List<Object> getAttachments()
    {
        return attachments;
    }

    /**
     * @param attachments the attachments to set
     */
    public void setAttachments(List<Object> attachments)
    {
        this.attachments = attachments;
    }
 
    
}
