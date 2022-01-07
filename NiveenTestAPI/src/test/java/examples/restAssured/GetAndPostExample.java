package examples.restAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class GetAndPostExample {
  @Test
  public void getTestOne() {
	  baseURI="https://reqres.in/api";
	 
	  given().
	    get("/users?page=2").
	  then().
	    statusCode(200).body("data[2].first_name", equalTo("Tobias")).
	    body("data.first_name",hasItems("Tobias","Lindsay")).
	    log().all();//log the body
	//search an item from collection use (hasItems())
  }
  
  @Test
  public void postTestCase() {
	  baseURI="https://reqres.in/api";
	/*  Map<String, Object> map = new HashMap();
	  map.put("name", "Niveen");
	  map.put("job", "QC");*/
	   
	  JSONObject req= new JSONObject();
	  req.put("name", "Niveen");
	  req.put("job", "QC");
	  System.out.println(req.toJSONString());
	  
	  //Post Request given.when.post.then 
	  given().
	    header("Content-Type","appliction/JSON").
	    contentType(ContentType.JSON).
	    accept(ContentType.JSON).
	    body(req.toJSONString()). 
	  when().
	    post("/users").
	  then().
	    statusCode(201).
	    log().all();
  }
}
