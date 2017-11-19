/************************************************************************************************************
 * Class Name :  StuckOrderDetailsDAO.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Nov 19, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.dao;

import java.util.ArrayList;

import com.zig.pso.rest.bean.OSHFMultiLineResponse;
import com.zig.pso.rest.bean.OSHFSingleLineResponse;

/**
 * 
 */
public interface StuckOrderDetailsDAO {

	
	 //segregation Of Orders 
    public ArrayList<OSHFSingleLineResponse> getOSHFSingleLineOrder();

	/**
	 * @return
	 */
	public ArrayList<OSHFMultiLineResponse> getOSHFMultiLineOrder();
}
