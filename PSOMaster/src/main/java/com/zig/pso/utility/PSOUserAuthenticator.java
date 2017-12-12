/************************************************************************************************************
 * Class Name :  PSOPasswordEncoder.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Nov 18, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 
 */
public class PSOUserAuthenticator
{
    public static String getHashedPassword(String plainTextValue)
    {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        
        return bcrypt.encode(plainTextValue);
    }
    
    public static boolean isUserAuthenticated(String password, String hashedDBPassword)
    {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        
        if(bcrypt.matches(password, hashedDBPassword))
            return true;
        else 
            return false;
    }
    
    public static boolean checkIfPasswordIsSame(String password, String hashedDBPassword)
    {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        return bcrypt.matches(password, hashedDBPassword);
    }
    
    public static void main(String[] args)
    {
        System.out.println(PSOUserAuthenticator.getHashedPassword("nilesh"));
    }
}
