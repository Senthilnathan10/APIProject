package com.globals;

/**
 * 
 * @author Senthil
 * @see purpose of this class is used to maintain common variables
 *@since 02-06-2023
 */

public class GlobalDatas {
	private int statuscode;
	private String stateId;
	private String cityId;
	private String logtoken;
	private String address_id;
	



	public String getAddress_id() { 
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

	public String getLogtoken() {
		return logtoken;
	}

	public void setLogtoken(String logtoken) {
		this.logtoken = logtoken;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public int getStatuscode() {
		return statuscode;
	}

	public int setStatuscode(int statuscode) {
		return this.statuscode = statuscode;
	}

	

	

	

}
