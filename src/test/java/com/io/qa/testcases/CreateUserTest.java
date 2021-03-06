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

public class CreateUserTest extends TestBase {
  @Test
  public void createUserTest() throws IOException {
	  log.debug("***************Started Executing createUserTest()********************************");
	  log.debug("assign the base url for RestAssured class baseURI variable");
	  RestAssured.baseURI=readProperty("baseurl");
	  log.debug("create the request object using RequestSpecification class & RestAssured class given()..");
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  log.debug("Adding the request headers...");
	  httpRequest.header("Content-Type", "application/json");
	  httpRequest.header("Accept", "application/json");
	  
	  log.debug("Create object for JSONObject class and add the request payload");
	  JSONObject requestParams=new JSONObject();
	  requestParams.put("name", "morpheus");
	  requestParams.put("job", "leader");
	  log.debug("attach this request parameters  to the Request ");
	  httpRequest.body(requestParams.toJSONString());
	  
	  log.debug("sending the POST request");
	  Response resp=httpRequest.request(Method.POST);
	  
	  log.debug("converting response object int ostring format");
	  String respBody=resp.getBody().asString();
	  log.debug("response body is-->"+respBody);
	  
	  log.debug("Validate status code");
	  int statusCode=resp.getStatusCode();
	  log.debug("status code is-->"+statusCode);
	  Assert.assertEquals(statusCode, 201);
	  
	  //validate the status line
	  String statLine=resp.getStatusLine();
	  log.debug("status line is-->"+statLine);
	  Assert.assertEquals(statLine, "HTTP/1.1 201 Created");
	  
	  //validating the response body paramters
	  log.debug("validating the response body paramters");
	  log.debug("fetch the name response value");
	  String nameVal=resp.jsonPath().get("name");
	  log.debug("actual response body name parameter value is-->"+nameVal);
	  Assert.assertEquals(nameVal, "morpheus");
	  
	  log.debug("fetch the job response value");
	  String jobVal=resp.jsonPath().get("job");
	  log.debug("actual response body job parameter value is-->"+jobVal);
	  Assert.assertEquals(jobVal, "leader");
	  
	  log.debug("fetch the id response value");
	  String idVal=resp.jsonPath().get("id");
	  log.debug("actual response body id parameter value is-->"+idVal);
	 
	  
	  log.debug("fetch the createAt response value");
	  String createdAtVal=resp.jsonPath().get("name");
	  log.debug("actual response body name parameter value is-->"+createdAtVal);
	 
	  
	  log.debug("******************************ENd of createUserTest()***********************************");
	  
	  
	  
  }
}
