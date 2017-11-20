/************************************************************************************************************
 * Class Name :  MailService.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Nov 19, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.service;

import com.zig.pso.rest.bean.Mail;

/**
 * 
 */
public interface MailService
{
    public void sendEmail(Mail mail);
}
