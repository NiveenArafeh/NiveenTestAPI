package examples.restAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchAndDeleteTest {
	
  @Test(priority=3)
  public void putTestCase() {
	  baseURI="https://reqres.in/api";
	
	   
	  JSONObject req= new JSONObject();
	  req.put("name", "Niveen");
	  req.put("job", "QC");
	  System.out.println(req.toJSONString());
	  
	
	  given().
	    header("Content-Type","appliction/JSON").
	    contentType(ContentType.JSON).
	    accept(ContentType.JSON).
	    body(req.toJSONString()). 
	  when().
	    put("/users/2").
	  then().
	    statusCode(200).
	    log().all();
  }
  
  @Test(priority=2)
  public void patchTestCase() {
	  baseURI="https://reqres.in/api";
	
	   
	  JSONObject req= new JSONObject();
	  req.put("name", "Ahmad");
	  req.put("job", "QC");
	  System.out.println(req.toJSONString());
	  
	
	  given().
	    header("Content-Type","appliction/JSON").
	    contentType(ContentType.JSON).
	    accept(ContentType.JSON).
	    body(req.toJSONString()). 
	  when().
	    patch("/users/2").
	  then().
	    statusCode(200).
	    log().all();
  }
  
  @Test(priority=1)
  public void deleteTestCase() {
	  baseURI="https://reqres.in/api";

	  when().
	    patch("/users/2").
	  then().
	    statusCode(200).//Or 204
	    log().all();
  }
}
