/************************************************************************************************************
 * Class Name :  EncryptDecryptPropertyUtil.java
 * Description:  This class encrypts or decrypts values based on jasypt algorithm
 * 
 * Author     :  Nilesh Patil
 * Date       :  Nov 18, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.utility;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import com.zig.pso.constants.PSOConstants;


/**
 * 
 */
public class PSOPropertyEncryptDecryptUtil
{
    public static String encryptValue(String dataValue)
    {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(PSOConstants.ENCRYPETER_PW);
        return encryptor.encrypt(dataValue);
    }
    
    public static String decryptValue(String dataValue)
    {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(PSOConstants.ENCRYPETER_PW);
        return encryptor.decrypt(dataValue);
    }
    
    public static void main(String[] args)
    {
        String encryptedVal = encryptValue("Zig_4c0nn");
        System.out.println(encryptedVal);
        
        String decryptedVal = decryptValue(encryptedVal);
        System.out.println(decryptedVal);
    }
}
