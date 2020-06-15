//Automated script to valid response given in test.json--> (Consider any url of your choice and write test cases to check whether the returned value is exactly the same as test.json)

package API;

import static org.testng.Assert.assertEquals;


import java.io.File; 

import java.util.Scanner; 

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

import org.apache.http.HttpStatus;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;

import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import net.javacrumbs.jsonunit.JsonAssert;

public class jsonvalidation {
	
	@Test
	   public void getresponse () throws InterruptedException, IOException, ParseException {
		String URL = "http://www.mocky.io/v2";
	    
		 RestAssured.baseURI= "http://www.mocky.io/v2";
		 //Requestopbject
		 RequestSpecification httprequest = RestAssured.given();
		 //getresponse body
		 Response response = httprequest.request(Method.GET,"/5e8f035c30000066bf64c02d");
		 String responsebody = response.getBody().asString();
		 //System.out.println("Response body is = " + responsebody);	//get the status code
		 int statuscode = response.getStatusCode();
		 System.out.println("Status code is " + statuscode);
		 Assert.assertEquals(statuscode, 200);
		 
		 //get the status line 
		 String statusline=  response.getStatusLine();
		 System.out.println("Status line is " + statusline);
		 Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
		 //read test.json
		 JSONParser jsonParser = new JSONParser();
		
		 FileReader reader = new FileReader("//Users//monikachaudhary//Downloads//test_2.json");
		 JSONObject jsonnew = (JSONObject) jsonParser.parse(reader);
		 System.out.println(jsonnew);
		 
		 
		 JSONParser parser = new JSONParser(); 
		 JSONArray json = (JSONArray) parser.parse(responsebody);
		 System.out.println( json.toString());
		 System.out.println( json.get(0));
		 //Assert.assertEquals(json.get(0), jsonnew);
			        
	}

	}  





