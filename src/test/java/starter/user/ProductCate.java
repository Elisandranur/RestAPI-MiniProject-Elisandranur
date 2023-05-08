package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.hasKey;
public class ProductCate {

    protected static String url = "https://altashop-api.fly.dev/api/";
    @Step
    public String endpointCategory() {
        return url + "categories";
    }

    @Step
    public void sendRequestCategory() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "DICOBA YAH");
        requestBody.put("description", "API WORKS");

        SerenityRest.given().header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw").body(requestBody.toJSONString()).post(endpointCategory());
    }

    @Step
    public void categoryResponse() {
        restAssuredThat(response -> response.body("$", hasKey("data")));

    }

    @Step
    public void sendCategoryREQ() {
        SerenityRest.given().header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw").get(endpointCategory());
    }

    @Step
    public void seeAllKategori() {
        restAssuredThat(response -> response.body("$", hasKey("data")));
    }
}

