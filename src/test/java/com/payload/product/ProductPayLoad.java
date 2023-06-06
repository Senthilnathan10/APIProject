package com.payload.product;

import com.pojo.product.SearchProduct_Input_Pojo;
/**
 * @author Senthil
 * @see purpose fo this class is used to maintain payload product inputs
 * @since 02-06-2023
 */

public class ProductPayLoad {
	
	public SearchProduct_Input_Pojo SearchProduct_Input_POJO(String text) {
		SearchProduct_Input_Pojo input_POJO = new SearchProduct_Input_Pojo("Nuts");
		return input_POJO;
	}
	

}
