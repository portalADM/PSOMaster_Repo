/************************************************************************************************************
 * Class Name :  StuckOrderDetailsResponse.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Nov 19, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 */
public class OSHFOrdersResponse implements Serializable {
	
	private static final long serialVersionUID = -166711097618929760L;
	private ArrayList<OSHFSingleLineResponse> OSHFSingleLineResponselist;
    private ArrayList<OSHFMultiLineResponse> OSHFMultiLineResponseList;

           /**
	 * @return the oSHFMultiLineResponseList
	 */
	public ArrayList<OSHFMultiLineResponse> getOSHFMultiLineResponseList() {
		return OSHFMultiLineResponseList;
	}

	/**
	 * @param oSHFMultiLineResponseList the oSHFMultiLineResponseList to set
	 */
	public void setOSHFMultiLineResponseList(ArrayList<OSHFMultiLineResponse> oSHFMultiLineResponseList) {
		OSHFMultiLineResponseList = oSHFMultiLineResponseList;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

		/**
	 * 
	 */
	
		/**
		 * @return the oSHFSingleLineResponselist
		 */
		public ArrayList<OSHFSingleLineResponse> getOSHFSingleLineResponselist() {
			return OSHFSingleLineResponselist;
		}

		/**
		 * @param oSHFSingleLineResponselist the oSHFSingleLineResponselist to set
		 */
		public void setOSHFSingleLineResponselist(ArrayList<OSHFSingleLineResponse> OSHFSingleLineResponselist) {
			this.OSHFSingleLineResponselist = OSHFSingleLineResponselist;
		}
           
           
}
