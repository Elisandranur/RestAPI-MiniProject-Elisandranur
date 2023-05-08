package starter.user;
import com.github.javafaker.Faker;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;
public class AuthenRegist {
    protected static String url = "https://altashop-api.fly.dev/api/";
    public static String email="";

    @Step
    public String endpointRegister() {
        return url + "auth/register";
    }

    @Step
    public void createRegisterVALID() {
        Faker faker = new Faker();
        email = faker.internet().emailAddress();
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", email);
        requestBody.put("password", "elisandra1");
        requestBody.put("fullname", "Elisandra");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toJSONString())
                .post(endpointRegister());
    }

    @Step
    public void statusCodeRegVALID() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step
    public void newDetailAcc() {
        restAssuredThat(response -> response.body("$", hasKey("data")));
    }

    @Step
    public void requestRegisterINVALID() {
        Faker faker = new Faker();
        email = faker.internet().emailAddress();
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", email);
        requestBody.put("password", "PASSWORD");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toJSONString())
                .post(endpointRegister());
    }
    @Step
    public void statusCodeRegInvalid() {
        restAssuredThat(response -> response.statusCode(400));
    }
}
