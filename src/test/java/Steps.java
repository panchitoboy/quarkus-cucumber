import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.quarkus.arc.Unremovable;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Unremovable
public class Steps {

  private ValidatableResponse result;

  Steps() {
    RestAssured.port = 8081;
  }


  @Given("I call the endpoint")
  public void i_call_endpoint() throws Exception {
    result = given()
        .when().get("/")
        .then();
  }

  @Then("the response is ok")
  public void response_is_ok() throws Exception {
    result.statusCode(200);
  }

}
