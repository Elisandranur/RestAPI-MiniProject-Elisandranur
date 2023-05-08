package starter.user;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.hasKey;

public class Order {
    protected static String url = "https://altashop-api.fly.dev/api/";
    protected static String token = "";

    @Step
    public String endpointOrder() {
        return url + "orders";
    }
    @Step
    public void loginValidAcc() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "someone@mail.com");
        requestBody.put("password", "123123");

        SerenityRest.given().header("Content-Type", "application/json").body(requestBody.toJSONString()).post(url+"auth/login");
        Response resp = SerenityRest.lastResponse();
        token = resp.getBody().jsonPath().get("data");
    }

    @Step
    public void inputTokenOrder() {
        JSONObject requestBody = new JSONObject();
        requestBody.put( "product_id",1);
        requestBody.put( "quantity",3);

        JSONArray bodyArray = new JSONArray();
        bodyArray.add(requestBody);
        SerenityRest.given()
                .header("Authorization", "Bearer "+token)
                .body(bodyArray.toJSONString())
                .post(endpointOrder());
    }

    @Step
    public void seeResponseOrder() {
        restAssuredThat(response -> response.body("$", hasKey("data")));
    }

    @Step
    public void sendRequestOrder() {
        SerenityRest.given().header("Authorization", "Bearer "+token).get(endpointOrder());
    }

    @Step
    public void listOrder() {
        restAssuredThat(response -> response.body("$", hasKey("data")));
    }
}
