package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Hello {
    protected static String url = "https://altashop-api.fly.dev/api/";

    @Step
    public String endpointHello() {
        return url + "hello";
    }

    @Step
    public void requestEndHello() {
        SerenityRest.given().get(endpointHello());
    }

    @Step
    public void statusCodeRequestHello(int arg0) {
        restAssuredThat(response -> response.statusCode(arg0));
    }

    @Step
    public void showHelloMessage() throws InterruptedException{
        Thread.sleep(3000);
    }
}
