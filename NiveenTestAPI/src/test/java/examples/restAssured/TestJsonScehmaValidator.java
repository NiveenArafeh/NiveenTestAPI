package examples.restAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.*;


import org.testng.annotations.Test;

public class TestJsonScehmaValidator {
  @Test
  public void testJSONScehmaValidator() {
	  
	  baseURI="https://reqres.in/api";
		 
	  given().
	    get("/users?page=2").
	  then().assertThat().
	  body(matchesJsonSchemaInClasspath("schema.json")).statusCode(200).log().all();
  }
}
