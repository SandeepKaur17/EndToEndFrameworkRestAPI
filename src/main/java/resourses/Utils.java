package resourses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	static RequestSpecification req;
	ResponseSpecification res;
	public RequestSpecification requestSpecification() throws IOException  {
		
		
		if(req==null) {
		
		PrintStream stream=new PrintStream(new FileOutputStream("Logs.txt"));
		req=new RequestSpecBuilder().setBaseUri(getProperties("baseUrl")).addQueryParam("key", "qaclick123")
		.addFilter(RequestLoggingFilter.logRequestTo(stream)).addFilter(ResponseLoggingFilter.logResponseTo(stream)).setContentType(ContentType.JSON).build();
		return req;
		}
		return req;
}
	
public ResponseSpecification responseSpecification() throws FileNotFoundException  {
		
	res=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	return res;
}

public static String getProperties(String key) throws IOException {
	
	Properties prop=new Properties();
	FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resourses/global.properties");
	
	prop.load(fs);
	return  prop.getProperty(key);
	
	
	
}

public String getJsonPath(Response resp ,String key) {
	
	String respo=resp.asString();
	JsonPath js =new JsonPath(respo);
	return js.get(key).toString();
}

}
