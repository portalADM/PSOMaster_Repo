/************************************************************************************************************
 * Class Name : SendMailUtility.java Description:
 * 
 * Author :Ankita Mishra Date : Oct 6, 2016 **********************************************************************************************************
 */
package com.zig.pso.utility;

import java.util.Properties;


import com.zig.pso.constants.PSOConstants;
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.EmailRequestBean;


/**
 * 
 */
public class SendMailUtility
{
    private static final String EMAIL_HOST = "punemail.corp.amdocs.com";
    private static final String EMAIL_FROM = "ankita.mishra@amdocs.com";
    private static final String AUTH_FALSE = "false";
    private static final String DEBUG_TRUE = "true";
    private static final boolean SESSION_DEBUG = true;
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    /**
     * @param emailRequest
     * @return
     */
    /**
     * @param emailRequest
     * @return
     */
    public synchronized static BaseResponseBean sendMail(EmailRequestBean emailRequest)
    {

        /*System.setProperty("java.net.preferIPv4Stack", "true");

        BaseResponseBean sentMailResponse = new BaseResponseBean();

        Properties props = new Properties();
        props.put("mail.smtp.host", EMAIL_HOST);

        Authenticator authenticator = null;
        authenticator = new RMEmailAuthenticator(USERNAME, PASSWORD);

        props.put("mail.smtp.auth", AUTH_FALSE);
        props.put("mail.smtp.debug", DEBUG_TRUE);

        try
        {
            Session session = Session.getDefaultInstance(props, authenticator);
            session.setDebug(SESSION_DEBUG);

            MimeMessage msg = new MimeMessage(session);
            msg.setSubject(emailRequest.getEmailSubject());
            msg.setFrom(new InternetAddress(EMAIL_FROM));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(emailRequest.getToEmailIdList()));
            msg.setRecipient(Message.RecipientType.CC, new InternetAddress(emailRequest.getCcEmailIdList()));

            
             * if (CollectionUtils.isNotEmpty(emailRequest.getToEmailIdList())) { for (String to : emailRequest.getToEmailIdList()) { msg.addRecipient(Message.RecipientType.TO, new
             * InternetAddress(to)); } } if (CollectionUtils.isNotEmpty(emailRequest.getCcEmailIdList())) { for (String cc : emailRequest.getCcEmailIdList()) {
             * msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc)); } }
             

            msg.setContent(emailRequest.getEmailContent(), "text/html; charset=utf-8");
            msg.saveChanges();

            Transport.send(msg);

            sentMailResponse.setErrorCode(PSOConstants.SUCCESS_CODE);
            sentMailResponse.setErrorMsg(PSOConstants.Successfully_sent_mail);
            return sentMailResponse;

        }
        catch (Exception mex)
        {
            sentMailResponse.setErrorCode(PSOConstants.ERROR_CODE);
            sentMailResponse.setErrorMsg(PSOConstants.Error_Occurred_While_sending_mail);
            return sentMailResponse;
        }*/
    	
    	return null;
    }
}
