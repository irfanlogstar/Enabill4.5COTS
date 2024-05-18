package Com.Enabill.Tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import Com.common.Methods.apicommonmethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class getAPITest extends basetest {
	
	
	
	@Test
	public void TC01_API_ListUsers()
	
	{
		String TCname="TC01_API_ListUsers";
		logger = extent.createTest(TCname);		
		String url = prop.getProperty("EndpointUrl")+APIdata.get(TCname).get("QueryParam");
		apicommonmethod api = new apicommonmethod(logger);
		Response resp=api.GetCall(url);
		api.ResponseValidation(resp,APIdata.get(TCname).get("Validation1"));
		api.ResponseValidation(resp,APIdata.get(TCname).get("Validation2"));
		api.ResponseValidation(resp,APIdata.get(TCname).get("Validation3"));
		api.ResponseValidation(resp,APIdata.get(TCname).get("Validation4"));
		extent.flush();
	}
	
	@Test
	public void TC03_API_CreateUserWithMap()
	{	
		String TCname="TC03_API_CreateUserWithMap";
		logger = extent.createTest(TCname);	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", APIdata.get(TCname).get("title"));
		map.put("body", APIdata.get(TCname).get("body"));
		map.put("userId", APIdata.get(TCname).get("userId"));
		String url = prop.getProperty("EndpointUrl1")+APIdata.get(TCname).get("QueryParam");
		JSONObject json = new JSONObject(map);
		RequestSpecification rs = RestAssured.given();
		rs.header("Content-Type","application/json");	
		rs.body(json.toString());
		logger.info("Request="+json.toString());
		apicommonmethod api = new apicommonmethod(logger);
		Response resp = api.PostCall(url,rs);
		api.ResponseValidation(resp,APIdata.get(TCname).get("Validation1"));
		api.ResponseValidation(resp,APIdata.get(TCname).get("Validation2"));
		extent.flush();	
	}
	
	
	@Test
	public void TC04_API_CreateUserWithFile()
	{	
		String TCname="TC04_API_CreateUserWithFile";
		logger = extent.createTest(TCname);			
		String url = prop.getProperty("EndpointUrl2")+APIdata.get(TCname).get("QueryParam");		
		RequestSpecification rs = RestAssured.given();
		rs.header("Content-Type","application/json");	
		File file = new File(System.getProperty("user.dir")+"/src/test/resources/Request/user.json");
		rs.body(file);
		logger.info("Request="+file.toString());
		apicommonmethod api = new apicommonmethod(logger);
		Response resp = api.PostCall(url,rs);
		api.ResponseValidation(resp,APIdata.get(TCname).get("Validation1"));
		api.ResponseValidation(resp,APIdata.get(TCname).get("Validation2"));	
		extent.flush();
	}
	@Test
	  public void TC04_API_CreateUserWithFileXML() {
        String TCname = "TC04_API_CreateUserWithFileXML";
        logger = extent.createTest(TCname);
        String url = prop.getProperty("EndpointUrl3") + APIdata.get(TCname).get("QueryParam");
        // Adding basic authentication credentials
        String username = "BalmerLawrieSAP";
        String password = "BLS@P#987";
        RequestSpecification rs = RestAssured.given();
        rs.auth().basic(username, password); // Adding basic authentication
        rs.header("Content-Type", "application/json");
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/Request/Receipt.xml");
        rs.body(file);
        logger.info("Request=" + file.toString());
        apicommonmethod api = new apicommonmethod(logger);
        Response resp = api.PostCall(url, rs);
        api.ResponseValidation(resp, APIdata.get(TCname).get("Validation1"));
        extent.flush();
    }
}


