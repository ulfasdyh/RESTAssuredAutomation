package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestOnLocalAPI {
	
	@Test
	public void getUsers() {
		
		baseURI = "http://localhost:3000";
		
		given().
			get("/users").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void addNewUser(){
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Ulfa");
		request.put("lastName", "Sadiyah");
		request.put("roleID", 2);
		
		System.out.println(request.toJSONString());
		
		baseURI = "http://localhost:3000";
		
		given().
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
	}
	
	@Test
	public void testPutUser() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Albert");
		request.put("lastName", "Einstein");
		request.put("roleID", 2);
		
		System.out.println(request.toJSONString());
		
		baseURI = "http://localhost:3000";
		
		given().
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
			put("/users/4").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void testPatchUser() {
		
		JSONObject request = new JSONObject();
		
		request.put("lastName", "Edison");
		request.put("roleID", 2);
		
		System.out.println(request.toJSONString());
		
		baseURI = "http://localhost:3000";
		
		given().
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
			patch("/users/4").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void testDeleteUser() {
		
		baseURI = "http://localhost:3000";
		
		when().
			delete("/users/4").
		then().
			statusCode(200).
			log().all();
	}


}
