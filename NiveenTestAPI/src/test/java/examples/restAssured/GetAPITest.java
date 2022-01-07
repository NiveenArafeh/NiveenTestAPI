package examples.restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;


public class GetAPITest {

	@Test
	public void runTestCaseOne() {
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println("The body of this response  is : " + response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));

		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test
	public void runTestCaseTwo() {
		baseURI = "https://reqres.in/api";
		given().
		  get("/users?page=2").
		then().
		  statusCode(200).body("data[1].id", equalTo(8)).
		  log().all();//to log the response
	}
}
