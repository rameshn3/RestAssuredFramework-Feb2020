package com.io.qa.testcases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.io.qa.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteUserTest extends TestBase {
  @Test
  public void deleteUserTest() throws IOException {
	  log.debug("***************Started Executing deleteUserTest()********************************");
	  log.debug("assign the base url for RestAssured class baseURI variable");
	  RestAssured.baseURI=readProperty("baseurl");
	  log.debug("create the request object using RequestSpecification class & RestAssured class given()..");
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  log.debug("Adding the request headers...");
	  httpRequest.header("Content-Type", "application/json");
	  httpRequest.header("Accept", "application/json");
	  
	    
	  log.debug("sending the POST request");
	  Response resp=httpRequest.request(Method.DELETE,"/2");
	  
	  //get all response headers
	  log.debug("response headers -->"+resp.getHeaders());
	  
	  log.debug("converting response object int ostring format");
	  String respBody=resp.getBody().asString();
	  log.debug("response body is-->"+respBody);
	  
	  log.debug("Validate status code");
	  int statusCode=resp.getStatusCode();
	  log.debug("status code is-->"+statusCode);
	  Assert.assertEquals(statusCode, 204);
	  
	  //validate the status line
	  String statLine=resp.getStatusLine();
	  log.debug("status line is-->"+statLine);
	  Assert.assertEquals(statLine, "HTTP/1.1 204 No Content");
	 
	  log.debug("******************************ENd of deleteUserTest()***********************************");
	  
	  
	  
  }
}
