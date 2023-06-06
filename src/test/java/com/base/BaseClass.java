package com.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/**
 * @author Senthil
 * @see purpose of this class is used maintain resuable codes for this project 
 * @since 02-06-2023
 *
 */

public class BaseClass {
	RequestSpecification reqspec;
	public static Response response;
	
	/**
	 * @author Senthil
	 * @see this method is used to add header inputs
	 * @param Key(String)
	 * @param Value(String)
	 * @since 02-06-2023
	 */

	public void addHeader(String Key, String Value) {
		 reqspec = RestAssured.given().header(Key, Value);
	}
	/**
	 * * @author Senthil
	 * @see this method is used to add path parameter inputs
	 * @param Key(String)
	 * @param Value(String)
	 * @since 02-06-2023
	 */

	public void addPathParam(String Key, String Value) {
		reqspec = reqspec.pathParam(Key, Value);

	}
	/**
	 * @author Senthil
	 * @see this method is used to add path parameter inputs
	 * @param Key(String)
	 * @param Value(String)
	 * @since 02-06-2023
	 */
	public void addQueryParam(String Key, String Value) {
		reqspec = reqspec.queryParam(Key, Value);

	}
	/**
	 * @author Senthil
	 * @see this method is useds to add Body inputs
	 * @param body(String)
	 * @since 02-06-2023
	 */

	public void addBody(String body) {
		reqspec = reqspec.body(body);

	}
	/**
	 * @author Senthil
	 * @see this method is useds to add Body inputs
	 * @param body(Object)
	 * @since 02-06-2023
	 */
	public void addBody(Object body) {
		
		reqspec = reqspec.body(body);

	}
	/**
	 * @author Senthil
	 * @see this method is used to add headers inputs
	 * @param headers (headers)
	 * @since 02-06-2023
	 */

	public void addHeaders(Headers headers) {
		reqspec = RestAssured.given().headers(headers);
		

	}
	/**
	 * @author Senthil
	 * @param type(String)
	 * @param endPoint(String)
	 * @return which will return response message
	 * @since 02-06-2023 
	 */
	

	public Response addReqType(String type, String endPoint) {
		switch (type) {
		case "GET":
			response = reqspec.log().all().get(endPoint);
			break;
		case "POST":
			response = reqspec.log().all().post(endPoint);
			break;
		case "PUT":
			response = reqspec.log().all().put(endPoint);
			break;
		case "PATCH":
			response = reqspec.log().all().patch(endPoint);
			break;
		case "DELETE":
			response = reqspec.log().all().delete(endPoint);
			break;

		default:
			break;
		}
		return response;
	}
		
	/**
	 * @author Senthil
	 * @param response
	 * @return Which will return statuscode meswsage as int
	 * @since 02-06-2023
	 */

	public int getStateusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;

	}
	/**
	 * @author Senthil
	 * @param response
	 * @return which will return asString messgae as String
	 * @since 02-06-2023
	 */

	public String getResBodyAsString(Response response) {
		String asString = response.asString();
		return asString;

	}
	/**
	 * @author Senthil
	 * @param response
	 * @return which will return asPrettyString message as String
	 * @since 02-06-2023
	 */

	public String getResBodyAsPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;

	}
	/**
	 * @author Senthil
	 * @param Username(String)
	 * @param Password(String)
	 * @since 02-06-2023
	 */
	public void addBasicAuth(String Username , String Password) {
		reqspec = reqspec.auth().preemptive().basic(Username, Password);

	}
	/**
	 * @author Senthil
	 * @return which will return getproperty as String
	 * @since 02-06-2023
	 */
	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}
	/**
	 * @author Senthl
	 * @param key
	 * @return Which will return value as String
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @since 02-06-2023
	 */
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\config\\config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		System.out.println(value);
		return value;
		
		
		
	}
	
	
}





