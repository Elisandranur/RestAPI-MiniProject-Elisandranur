package starter.user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.hasKey;

public class Product {

    protected static String url = "https://altashop-api.fly.dev/api/";

    @Step
    public String endpointProduct() {
        return url + "products";
    }

    @Step
    public void sendRequestValidProduct() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "IPHONE 15 PRO");
        requestBody.put("description", "HENGPON");
        requestBody.put("price", 450);

        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw")
                .body(requestBody.toJSONString())
                .post(endpointProduct());
    }

    @Step
    public void seeDetailProduct() {
        restAssuredThat(response -> response.body("$", hasKey("data")));
    }

    @Step
    public void iSendRequest() {
        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw")
                .get(endpointProduct());
    }

    @Step
    public void seeProduct() {
        restAssuredThat(response -> response.body("$", hasKey("data")));
    }

    @Step
    public String endpointDeleteProduct() {
        return url + "products/187";
    }

    @Step
    public void sendRequestDelProd() {
        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw")
                .delete(endpointDeleteProduct());
    }

    @Step
    public void validateDeleting() {
        restAssuredThat(response -> response.body("$", hasKey("data")));
    }

    @Step
    public String endpointCommentProd() {
        return url + "products/2/comments";
    }

    @Step
    public void requestComment() {
        SerenityRest.given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw")
                .get(endpointCommentProd());
    }

    @Step
    public void receiveDataComment() {
        restAssuredThat(response -> response.body("$", hasKey("data")));
    }
}
