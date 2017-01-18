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
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 */
public class StuckOrderBacklogUiResponseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] dateList;
	private String[] statusCodes;
	private HashMap<String, ArrayList<Integer>> statusDayWiseCount;

}
