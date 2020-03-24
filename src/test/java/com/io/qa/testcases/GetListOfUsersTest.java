package com.io.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.io.qa.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetListOfUsersTest extends TestBase {
  @Test
  public void getListOfUsersTest() throws IOException {
	  log.debug("***************Started Executing getListOfUsersTest()********************************");
	  log.debug("assign the base url for RestAssured class baseURI variable");
	  RestAssured.baseURI=readProperty("baseurl");
	  log.debug("create the request object using RequestSpecification class & RestAssured class given()..");
	  RequestSpecification httpRequest=RestAssured.given();
	  log.debug("sending the GET request");
	  Response resp=httpRequest.request(Method.GET, "?page=2");
	  
	  log.debug("converting response object int ostring format");
	  String respBody=resp.getBody().asString();
	  log.debug("response body is-->"+respBody);
	  
	  log.debug("Validate status code");
	  int statusCode=resp.getStatusCode();
	  log.debug("status code is-->"+statusCode);
	  Assert.assertEquals(statusCode, 200);
	  
	  //validate the status line
	  String statLine=resp.getStatusLine();
	  log.debug("status line is-->"+statLine);
	  Assert.assertEquals(statLine, "HTTP/1.1 200 OK");
	  log.debug("******************************ENd of getListOfUsersTest()***********************************");
	  
	  
	  
  }
}
