package Com.Enabill.Tests;

import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import junit.framework.Assert;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GETAPI {
	
	@Test
	public void TC01_ListUsers()
	{
		String  resp = RestAssured.get("https://reqres.in/api/users?page=2").getStatusLine();
		System.out.println(resp);
		Assert.assertEquals("HTTP/1.1 200 OK",resp);
		int  code = RestAssured.get("https://reqres.in/api/users?page=2").getStatusCode();
		System.out.println(code);
		Assert.assertEquals(200,code);
		String code1 = RestAssured.get("https://reqres.in/api/users?page=2").asString();
		System.out.println(code1);
		
	}
	@Test
	public void  assured2()
	{
		given().param("page", "2").auth().none()
		.when().get("https://reqres.in/api/users")
		.then().statusCode(200).body("page", equalTo(2));
	}
	@Test
	public void assured3()
	{
		given()
        .when()
            .get("https://reqres.in/api/users?page=2")
        .then()
            .statusCode(200)
            .body("page", equalTo(2));
           
	}

}
