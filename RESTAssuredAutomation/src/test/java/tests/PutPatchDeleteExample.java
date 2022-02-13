package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PutPatchDeleteExample {
	
	@Test
	public void testPutUser() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Ulfa Sadiyah");
		request.put("job", "QA Engineer");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void testPatchUser() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Ulfa Sadiyah");
		request.put("job", "QA Engineer");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in";
		
		given().
			header("Content-Type","application/json").
			body(request.toJSONString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void testDeleteUser() {
		
		baseURI = "https://reqres.in";
		
		when().
			delete("/api/users/2").
		then().
			statusCode(204).
			log().all();
	}

}
