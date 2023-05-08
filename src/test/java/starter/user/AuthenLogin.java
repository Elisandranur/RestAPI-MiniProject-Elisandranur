package starter.user;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;
public class AuthenLogin {


    protected static String url = "https://altashop-api.fly.dev/api/";

    @Step
    public String endpointLogin() {
        return url + "auth/login";
    }

    @Step
    public void postHTTPRequestValidData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "someone@mail.com");
        requestBody.put("password", "123123");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(endpointLogin());
    }

    @Step
    public void statusCodeLoginValid() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step
    public void getValidData() {
        restAssuredThat(response -> response.body("$", hasKey("data")));
    }

    @Step
    public void postRequestInvalidData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "someone@mail.com");
        requestBody.put("password", "SALAHYA");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(endpointLogin());
    }

    @Step("user see status code 400")
    public void statusCodeLoginInvalid() {
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step
    public void getErrorMessage() {
        restAssuredThat(response -> response.body("'error'", equalTo("email or password is invalid")));
    }
}
