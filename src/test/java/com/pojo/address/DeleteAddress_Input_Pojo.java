package com.pojo.address;

public class DeleteAddress_Input_Pojo {
	private String address_id;
	private String message;
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DeleteAddress_Input_Pojo(String address_id) {
		super();
		this.address_id = address_id;
	}

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}
	

}
