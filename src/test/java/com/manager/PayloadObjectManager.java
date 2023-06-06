package com.manager;

import com.payload.address.AddressPayLoad;

/**
 * @author Senthil
 * @see purpose of this class is used to manage payLoad
 * @@since 02-06-2023
 */
import com.payload.product.ProductPayLoad;

public class PayloadObjectManager {

private AddressPayLoad addresspayload;
private ProductPayLoad productpayload;



public AddressPayLoad getAddresspayload() {
return (addresspayload == null)? addresspayload = new AddressPayLoad() : addresspayload;
}

public ProductPayLoad getProductpayload() {
return (productpayload == null)? productpayload = new ProductPayLoad() :productpayload;
}

}

