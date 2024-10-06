package com.stepDefinitions;

import com.TestData.AddLocations;
import com.Utility.Constant;
import com.Utility.UtilityFile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.Pojos.com.AddLocation;

import java.lang.constant.Constable;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class StepDefinition extends UtilityFile {

    RequestSpecification body;
    Response response;
    AddLocations addLocation = new AddLocations();
    static Object placeId;
    @Given("Add place payload as {string} {string} {string} {string} {string} {string} {double} {double}")
    public void add_place_payload_as(String Accuracy, String Address, String Name, String PhoneNumber, String Shoe, String Shop, Double Latitud, Double Langitud) {
         body = given().log().all().spec(getRequestSpecification()).body(addLocation.add_Location(Accuracy,Address,Name,PhoneNumber,Shoe,Shop,Latitud,Langitud));
    }

    @When("user uses the post method when {string} as {string}")
    public void user_uses_the_post_method_when_as(String Request, String HttpMethod) {
        Constant constant = Constant.valueOf(Request);
        System.out.println(constant.getSource());
        if (HttpMethod.equalsIgnoreCase("Post")) {
            response = body.when().log().all().post(constant.getSource()).then().log().all().extract().response();
        } else if (HttpMethod.equalsIgnoreCase("Get")) {
            response = body.when().log().all().get(constant.getSource()).then().log().all().extract().response();
        } else if (HttpMethod.equalsIgnoreCase("Put")) {
            body.when().log().all().put(constant.getSource()).then().log().all().extract().response();
        }
        else if (HttpMethod.equalsIgnoreCase("Delete")) {
            body.when().log().all().delete(constant.getSource()).then().log().all().assertThat().statusCode(200).extract().response();
        }
    }

    @Then("verify JsonResponse based on HttpRequest as {string}")
    public void verify_json_response_based_on_http_request_as(String HttpMethod) {
        if(HttpMethod.equalsIgnoreCase("Post")){
         String string = response.asString();
         System.out.println(string);
            Object status = getJsonResponse(string, "status");
            assertEquals("OK",status);

        }
    }

    @Then("verify the place is added by using {string} request when {string} the name should be {string}")
    public void verify_the_place_is_added_by_using_get_request_when_the_name_should_be(String HttpRequest,String Request,String Name) {


           String string = response.asString();
            placeId = getJsonResponse(string, "place_id");
            body = given().spec(getRequestSpecification()).queryParam("place_id", placeId);
            user_uses_the_post_method_when_as(Request,HttpRequest);
        String string1 = response.asString();
        Object name = getJsonResponse(string1, "Name");
        AddLocation addLocation1 = new AddLocation();
        assertEquals(addLocation1.getName(),name);
    }

    @Then("change the Address by using {string} Request as {string}")
    public void change_the_address_by_using_request_as(String request,String HTTPMethod) {

        String string = response.asString();
        System.out.println("Get Response before put request =======" + string+ "=======================");
        Object address = getJsonResponse(string, "address");
        body = given().spec(getRequestSpecification()).body(update_LocationBody(String.valueOf(placeId),"80,hongkong","qaclick123"));
        user_uses_the_post_method_when_as(request,HTTPMethod);
        String string1 = response.asString();
        Object address1 = getJsonResponse(string1, "address");
        assertEquals(address,address1);
    }


    @And("Delete the location that we added using {string} as {string}")
    public void deleteTheLocationThatWeAddedUsingAs(String request, String HttpMethod) {

         body = given().spec(getRequestSpecification()).body(delete_LocationBody(placeId));
         user_uses_the_post_method_when_as(request,HttpMethod);

    }
}
