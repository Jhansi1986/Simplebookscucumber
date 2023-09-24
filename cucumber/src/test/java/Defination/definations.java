package Defination;

import java.io.IOException;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import utility.dataconverter;

public class definations {

	public static String BaseURL = "https://simple-books-api.glitch.me";
	public static String Authenticatebody;
	RequestSpecification requestspecification;
	Response response;
	public static String Token;
	public static String orderID;
	public static String createorderbody;
	

	@Given("Authentication baseurl along with body")
	public void authentication_baseurl_along_with_body() throws IOException {
		Authenticatebody = dataconverter.generatepayload("simplebooks.json");
	    
	}
	@When("Execute the authenticate {string} which provides accessToken")
	public void execute_the_authenticate_which_provides_access_token(String resourcepath) {
		requestspecification = RestAssured.given().body(Authenticatebody);
		requestspecification.contentType(ContentType.JSON);
		response = requestspecification.post(BaseURL + resourcepath);
		
	    
	}
	@Then("Verifying the accessToken and staus code is {int} in the response")
	public void verifying_the_access_token_and_staus_code_is_in_the_response(int expectedstatus) {
		System.out.println(response.getStatusCode());
		Assert.assertEquals(expectedstatus, response.getStatusCode());
		
		
	    
	}
	@Then("verify the accessToken in the response")
	public void verify_the_access_token_in_the_response() {
		System.out.println(response.asPrettyString());
		JsonPath js = new JsonPath(response.asString());
		Token = js.getString("accessToken");
		System.out.println(Token);
	    
	}
	@Given("creating order by using Authentication baseurl along with body")
	public void creating_order_by_using_authentication_baseurl_along_with_body() throws IOException {
	   createorderbody = dataconverter.generatepayload("createorder.json");
	}
	@When("While creating a orders {string} this will helps to create a order")
	public void while_creating_a_orders_this_will_helps_to_create_a_order(String resourcepath) {
	  requestspecification = RestAssured.given().body(createorderbody);
	  requestspecification.contentType(ContentType.JSON);
	  requestspecification.header("Authorization","Bearer "+ Token);
	  response = requestspecification.post(BaseURL + resourcepath);
	}
	@Then("Verifying the accessToken order details and staus code is {int} in the response")
	public void verifying_the_access_token_order_details_and_staus_code_is_in_the_response(int expectedstatus) {
		System.out.println(response.getStatusCode());
		Assert.assertEquals(expectedstatus, response.getStatusCode());
	    
	}
	@Then("verify the orderId in the response")
	public void verify_the_order_id_in_the_response() {
		System.out.println(response.asPrettyString());
		JsonPath js = new JsonPath(response.asPrettyString());
		orderID = js.getString("orderId");
		System.out.println(orderID);
	    
	}




}
