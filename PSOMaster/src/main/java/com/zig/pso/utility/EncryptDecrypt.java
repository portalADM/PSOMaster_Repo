/************************************************************************************************************
 * Class Name :  EncryptDecrypt.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Nov 18, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.utility;


import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;


public class EncryptDecrypt {
    private final String propertyFileName;
    private final String propertyKey;
    private final String isPropertyKeyEncrypted;

    final String decryptedUserPassword;

    /**
     * The constructor does most of the work.
     * It initializes all final variables and invoke two methods
     * for encryption and decryption job. After successful job
     * the constructor puts the decrypted password in variable
     * to be retrieved by calling class.
     * 
     * 
     * @param pPropertyFileName /Name of the properties file that contains the password
     * @param pUserPasswordKey  /Left hand side of the password property as key. 
     * @param pIsPasswordEncryptedKey   /Key in the properties file that will tell us if the password is already encrypted or not
     * 
     * @throws Exception
     */
    public EncryptDecrypt(String pPropertyFileName,String pUserPasswordKey, String pIsPasswordEncryptedKey) throws Exception {
        this.propertyFileName = pPropertyFileName;
        this.propertyKey = pUserPasswordKey;
        this.isPropertyKeyEncrypted = pIsPasswordEncryptedKey;
        try {
            encryptPropertyValue();
        } catch (ConfigurationException e) {
            throw new Exception("Problem encountered during encryption process",e);
        }
        decryptedUserPassword = decryptPropertyValue();

    }

    /**
     * The method that encrypt password in the properties file. 
     * This method will first check if the password is already encrypted or not. 
     * If not then only it will encrypt the password.
     * 
     * @throws ConfigurationException
     */
    private void encryptPropertyValue() throws ConfigurationException {
        System.out.println("Starting encryption operation");
        System.out.println("Start reading properties file");

        //Apache Commons Configuration 
        PropertiesConfiguration config = new PropertiesConfiguration(propertyFileName);

        //Retrieve boolean properties value to see if password is already encrypted or not
        String isEncrypted = config.getString(isPropertyKeyEncrypted);

        //Check if password is encrypted?
        if(isEncrypted.equals("false")){
            String tmpPwd = config.getString(propertyKey);
            //System.out.println(tmpPwd); 
            //Encrypt
            StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
            // This is a required password for Jasypt. You will have to use the same password to
            // retrieve decrypted password later. T
            // This password is not the password we are trying to encrypt taken from properties file.
            encryptor.setPassword("jasypt");
            String encryptedPassword = encryptor.encrypt(tmpPwd);
            System.out.println("Encryption done and encrypted password is : " + encryptedPassword ); 

            // Overwrite password with encrypted password in the properties file using Apache Commons Cinfiguration library
            config.setProperty(propertyKey, encryptedPassword);
            // Set the boolean flag to true to indicate future encryption operation that password is already encrypted
            config.setProperty(isPropertyKeyEncrypted,"true");
            // Save the properties file
            config.save();
        }else{
             System.out.println("User password is already encrypted.\n ");
        }
    }

    private String decryptPropertyValue() throws ConfigurationException {
         System.out.println("Starting decryption");
        PropertiesConfiguration config = new PropertiesConfiguration(propertyFileName);
        
        String encryptedPropertyValue = config.getString(propertyKey);
        //System.out.println(encryptedPropertyValue); 

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("jasypt");
        String decryptedPropertyValue = encryptor.decrypt(encryptedPropertyValue);
        //System.out.println(decryptedPropertyValue); 

        return decryptedPropertyValue;
    }
}