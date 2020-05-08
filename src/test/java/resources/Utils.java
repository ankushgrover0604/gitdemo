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
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	static RequestSpecification res;
	public RequestSpecification requestSpecification() throws IOException {
	
	if(res==null) {	
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
	res = new RequestSpecBuilder().setBaseUri(propertiesutils("url")).addQueryParam("key", "qaclick123")
			.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
	.setContentType(ContentType.JSON).build();
	return res;
	}
	return res;
}

public static String propertiesutils(String key) throws IOException {
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream("C:\\Users\\ankush.grover\\eclipse-workspace\\bddFrameworkApi\\src\\test\\java\\resources\\global.properties");
	prop.load(fis);
	return prop.getProperty(key);
	
	
}

public String getJsonpath(Response reswhen , String Key)
{
	   String responseString = reswhen.asString();
	 JsonPath js = new JsonPath(responseString);
	 return js.get(Key).toString();

}
}
