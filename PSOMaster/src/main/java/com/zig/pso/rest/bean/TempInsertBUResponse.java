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
    private String bulkUpdateId;

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

    /**
     * @return the bulkUpdateId
     */
    public String getBulkUpdateId()
    {
        return bulkUpdateId;
    }

    /**
     * @param bulkUpdateId the bulkUpdateId to set
     */
    public void setBulkUpdateId(String bulkUpdateId)
    {
        this.bulkUpdateId = bulkUpdateId;
    }

}
