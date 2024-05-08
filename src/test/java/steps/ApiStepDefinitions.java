package steps;

import io.cucumber.java.en.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;


public class ApiStepDefinitions {
    private Response response;
    @When("a user sends a GET request to the API")
    public void a_user_sends_a_get_request_to_the_api() {
        RequestSpecification request = given();
        response = request.get("https://www.boredapi.com/api/activity");
    }
    @Then("the response code should be {int}")
    public void the_response_code_should_be(Integer code) {
        response.then().statusCode(code);
    }
    @Then("the response should match the schema")
    public void the_response_should_match_the_schema() {
        response.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("api-schema.json"))
                .extract().response();
    }
}

