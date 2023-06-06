package com.payload.address;


import com.pojo.address.AddUserAddress_Input_Pojo;

/**
 * @author Senthil
 * @see purpose fo this class is used to maintain payload address inputs
 * @since 02-06-2023
 */
import com.pojo.address.UpdateUserAddress_Input_Pojo;

public class AddressPayLoad {
	public AddUserAddress_Input_Pojo addAddressPayLoad(String first_name, String last_name, String mobileno,
			String apartment, int stateId, int cityId, int countryId, String zipcode, String address,
			String address_Type) {

		AddUserAddress_Input_Pojo addUserAddress_Input_Pojo = new AddUserAddress_Input_Pojo(first_name, last_name,
				mobileno, apartment, stateId, cityId, countryId, zipcode, address, address_Type);

		return addUserAddress_Input_Pojo;
	}
	
	public UpdateUserAddress_Input_Pojo updateAddressPayLoad(String address_id,String first_name, String last_name, String mobileno,
			String apartment, int stateId, int cityId, int countryId, String zipcode, String address,
			String address_Type) {
		
		UpdateUserAddress_Input_Pojo updateUserAddress_Input_Pojo = new UpdateUserAddress_Input_Pojo(address_id, first_name, last_name, mobileno, apartment, stateId, cityId, countryId, zipcode, address, address_Type);
		return updateUserAddress_Input_Pojo;
		
	}
		

	}
	
	

