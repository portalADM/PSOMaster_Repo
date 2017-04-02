/************************************************************************************************************
 * Class Name :  ColumnDataListBean.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Mar 28, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
public class ColumnDataListBean implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 8324290846634702065L;
    private String colName;
    private String colValue;
    /**
     * @return the colName
     */
    public String getColName()
    {
        return colName;
    }
    /**
     * @param colName the colName to set
     */
    public void setColName(String colName)
    {
        this.colName = colName;
    }
    /**
     * @return the colValue
     */
    public String getColValue()
    {
        return colValue;
    }
    /**
     * @param colValue the colValue to set
     */
    public void setColValue(String colValue)
    {
        this.colValue = colValue;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((colName == null) ? 0 : colName.hashCode());
        result = prime * result + ((colValue == null) ? 0 : colValue.hashCode());
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
        ColumnDataListBean other = (ColumnDataListBean) obj;
        if (colName == null)
        {
            if (other.colName != null)
                return false;
        }
        else if (!colName.equals(other.colName))
            return false;
        if (colValue == null)
        {
            if (other.colValue != null)
                return false;
        }
        else if (!colValue.equals(other.colValue))
            return false;
        return true;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "ColumnDataListBean [colName=" + colName + ", colValue=" + colValue + "]";
    }
    
    
    
}
