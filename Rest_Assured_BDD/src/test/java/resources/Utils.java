package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	RequestSpecification req;
	
	public RequestSpecification requestspecification() throws IOException{
		PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
		RestAssured.baseURI="https://reqres.in";
		 req =new RequestSpecBuilder().setBaseUri(getglobalvalue("baseuri"))
//				 .addQueryParam("key", "qaclick123")
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
//				 .addHeader("Content-Type","application/json")
		.setContentType(ContentType.JSON).build();
		 return req;
	}
	public static String getglobalvalue(String key) throws IOException {
		Properties prop =new Properties();
		String usrdir=System.getProperty("user.dir");
		FileInputStream fil=new FileInputStream(usrdir+"\\src\\test\\java\\resources\\global.properties");
		prop.load(fil);
		return prop.getProperty(key);
//		return prop;
	}

}
