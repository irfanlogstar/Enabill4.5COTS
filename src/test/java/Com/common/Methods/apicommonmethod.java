package Com.common.Methods;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentTest;


import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class apicommonmethod {
	

	public ExtentTest logger;
	
	public apicommonmethod(ExtentTest logger)
	{
		this.logger=logger;
	}
	
	public void ResponseValidation(Response resp,String validation)
	{
		try
		{
		String[] val = validation.split("=");
		if(resp.body().jsonPath().getString(val[0]).equals(val[1]))
		{
			logger.pass("Json path matched  "+val[0]+" with value "+val[1]+"  in json response");
		}
		else
		{
			logger.fail("Json path did not match  "+val[0]+" with value "+val[1]+"  in json response");
		}
		}
		catch(Exception e)
		{
			logger.fail(e.getMessage());
			System.out.println(e.getMessage());
		}
	}
	
	
	public Response GetCall(String url)
	{	
		Response resp = get(url);
		logger.info("Get Url:"+ url);
		String body = resp.getBody().asString();
		
		System.out.println(resp.asPrettyString());
		logger.info("Response :"+resp.asPrettyString());
		//get("/lotto").then().assertThat().body("lotto.lottoId", equalTo(5));		
		if(resp.getStatusLine().equals("HTTP/1.1 200 OK"))
		{
		logger.pass("Status Line Matched with "+resp.getStatusLine());
		}
		else
		{
			logger.fail(resp.getStatusLine());
		}
		
		return resp;
	}
	
	public Response PostCall(String url, RequestSpecification req)
	{	
		Response resp = req.post(url);
		logger.info("Post Url:"+ url);
		String body = resp.getBody().asString();
		
		System.out.println(resp.asPrettyString());
		logger.info("Response :"+resp.asPrettyString());		
		if(resp.getStatusLine().equals("HTTP/1.1 201 Created"))
		{
		logger.pass("Status Line Matched with "+resp.getStatusLine());
		}
		else
		{
			logger.fail(resp.getStatusLine());
		}
		
		return resp;
	}

}



