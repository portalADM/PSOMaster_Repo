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
import java.util.List;

/**
 * 
 */
public class OSHFOrdersResponse implements Serializable {
	
	private static final long serialVersionUID = -166711097618929760L;
	private List<OSHFSingleLineResponse> oSHFSingleLineResponselist;
    private List<OSHFMultiLineResponse> oSHFMultiLineResponseList;

           /**
	 * @return the oSHFMultiLineResponseList
	 */
	public List<OSHFMultiLineResponse> getOSHFMultiLineResponseList() {
		return oSHFMultiLineResponseList;
	}

	/**
	 * @param oSHFMultiLineResponseList the oSHFMultiLineResponseList to set
	 */
	public void setOSHFMultiLineResponseList(List<OSHFMultiLineResponse> oSHFMultiLineResponseList) {
	    this.oSHFMultiLineResponseList = oSHFMultiLineResponseList;
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
		public List<OSHFSingleLineResponse> getOSHFSingleLineResponselist() {
			return oSHFSingleLineResponselist;
		}

		/**
		 * @param oSHFSingleLineResponselist the oSHFSingleLineResponselist to set
		 */
		public void setOSHFSingleLineResponselist(List<OSHFSingleLineResponse> OSHFSingleLineResponselist) {
			this.oSHFSingleLineResponselist = OSHFSingleLineResponselist;
		}
           
           
}
