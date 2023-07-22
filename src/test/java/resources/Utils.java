package resources;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;

import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification req;
	
	public String getGlobalValue(String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
		
	}
	
	public RequestSpecification requestSpecification() throws IOException
	{
	if(req==null)
	{
	
		req = new RequestSpecBuilder().setBaseUri( getGlobalValue("baseurl")).build();
	
	return req;
		
	}
	return req;

}
}
