/************************************************************************************************************
 * Class Name :  StuckOrderBacklogResponseBean.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Jan 18, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 
 */
public class StuckOrderBacklogUiResponseBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<String> dateList; 
	private LinkedHashMap<String, List<StuckOrderBacklogDBResultsBean>> backLogList;
    /**
     * @return the dateList
     */
    public List<String> getDateList()
    {
        return dateList;
    }
    /**
     * @param dateList the dateList to set
     */
    public void setDateList(List<String> dateList)
    {
        this.dateList = dateList;
    }
    /**
     * @return the backLogList
     */
    public HashMap<String, List<StuckOrderBacklogDBResultsBean>> getBackLogList()
    {
        return backLogList;
    }
    /**
     * @param backLogList the backLogList to set
     */
    public void setBackLogList(LinkedHashMap<String, List<StuckOrderBacklogDBResultsBean>> backLogList)
    {
        this.backLogList = backLogList;
    }

	

}
