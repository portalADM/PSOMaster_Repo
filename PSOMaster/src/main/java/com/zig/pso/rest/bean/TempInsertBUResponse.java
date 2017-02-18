/************************************************************************************************************
 * Class Name :  TempInsertBUResponse.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Feb 18, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

/**
 * 
 */
public class TempInsertBUResponse extends BaseResponseBean
{
    private String tempTableName;

    /**
     * @return the tempTableName
     */
    public String getTempTableName()
    {
        return tempTableName;
    }

    /**
     * @param tempTableName the tempTableName to set
     */
    public void setTempTableName(String tempTableName)
    {
        this.tempTableName = tempTableName;
    }

}
