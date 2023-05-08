package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.*;

public class UserSteps {
    @Steps
    AuthenLogin authenLogin;

    @Steps
    AuthenRegist authenRegist;

    @Steps
    Hello hello;

    @Steps
    Order order;

    @Steps
    ProductCate productCate;

    @Steps
    Product product;

    //AUTHENTICATION LOGIN//
    @Given("I set endpoint for login")
    public void userSetEndpointForLogin() {
        authenLogin.endpointLogin();
    }

    @When("Iam send POST HTTP request for valid data")
    public void userSendPOSTHTTPRequestWithValidData() {
        authenLogin.postHTTPRequestValidData();
    }

    @Then("seeing status code 200")
    public void userSeeStatusCode() {
        authenLogin.statusCodeLoginValid();
    }

    @And("get validation data and token")
    public void getValidData() {
        authenLogin.getValidData();
    }


    //AUTHENTICATION LOGIN INVALID INPUT//
    @When("Iam send POST HTTP request for invalid data")
    public void userSendPOSTHTTPRequestWithInvalidData() {
        authenLogin.postRequestInvalidData();
    }

    @Then("get the status code 400")
    public void userSeeStatusCode400() {
        authenLogin.statusCodeLoginInvalid();
    }

    @And("get error message for failed login")
    public void userGetErrorMessage() {
        authenLogin.getErrorMessage();
    }

    // AUTHENTICATION REGISTER VALID//
    @Given("Iam set endpoint for register")
    public void userSetEndpointForRegister() {
        authenRegist.endpointRegister();
    }

    @When("I send created account with valid data input")
    public void userSendCreateAccountWithValidData() {
        authenRegist.createRegisterVALID();
    }

    @Then("get status code 200 after send register")
    public void userSeeStatusCodeAfterSendRegister() {
        authenRegist.statusCodeRegVALID();
    }

    @And("I see new detail account")
    public void userSeeNewDetailAccount() {
        authenRegist.newDetailAcc();
    }

    //AUTHENTICATION REGISTER INVALID DATA INPUT//
    @When("I send HTTP request with empty FULLNAME data register")
    public void userSendPOSTHTTPRequestWithEmptyPasswordDataRegister() {
        authenRegist.requestRegisterINVALID();
    }

    @Then("I see status code 400")
    public void userSeeStatusCodeAndFailToCreateAccount() {
        authenRegist.statusCodeRegInvalid();
    }

    // MENDAPATKAN INDEX "HELLO"//
    @Given("Iam setting endpoint for hello")
    public void userSetEndpointForHello() {
        hello.endpointHello();
    }

    @When("Iam send request endpoint")
    public void userSendRequestToEndpoint() {
        hello.requestEndHello();
    }
    @And("I could see status code 200")
    public void statusCodeHello200(){hello.statusCodeRequestHello(200);}

    @Then("I saw show hello message")
    public void userShowHelloMessage() throws InterruptedException {
        hello.showHelloMessage() ;
    }


    // POST THE NEW ORDER//
    @Given("I set endpoint to order")
    public void userSetEndpointForOrder() {
        order.endpointOrder();
    }
    @And("I success login and going to order")
    public void userSuccessLoginWithValidAccount() {
        order.loginValidAcc();
    }
    @When("I input token authorization")
    public void userInputTokenInAuthorization() {
        order.inputTokenOrder();
    }
    @Then("user see status code 200 and new order response")
    public void userSeeNewOrderResponse() {
        order.seeResponseOrder();
    }

    // GET LIST OF ORDER //
    @When("I send request to endpoint order")
    public void userSendRequestToEndpointOrder() {
        order.sendRequestOrder();
    }

    @Then("I see status code 200 and user show list of the order")
    public void userShowListOfTheOrder() {
        order.listOrder();
    }


    // POST NEW PRODUCT //
    @Given("Iam setting endpoint for product")
    public void userSetEndpointForProduct() {
        product.endpointProduct();
    }

    @When("I send HTTP request to post valid data product")
    public void userSendPOSTHTTPRequestWithValidDataProduct() {
        product.sendRequestValidProduct();
    }
    @Then("I get status code 200")
    public void get200ProductPost(){}

    @And("iam seeing new detail product")
    public void userSeeNewDetailProduct() {
        product.seeDetailProduct();
    }

    // GET ALL PRODUCT THAT EXIST //
    @When("i send request HTTP get all product")
    public void userSendRequest() {
        product.iSendRequest();
    }

    @And("I can see all product")
    public void userSeeProduct() {
        product.seeProduct();
    }

    // DELETE PRODUCT ALREADY EXIST  //
    @Given("i set endpoint for delete product")
    public void userSetEndpointForDeleteProduct() {
        product.endpointDeleteProduct();
    }

    @When("i send request for delete product")
    public void userSendRequestForDeleteProduct() {
        product.sendRequestDelProd();
    }

    @And("I receive valid data for deleting product")
    public void userReceiveValidDataForDeletingProduct() {
        product.validateDeleting();
    }

    // GET PRODUCT COMMENT //
    @Given("I set the endpoint for product comment")
    public void userSetEndpointForProductComments() {
        product.endpointCommentProd();
    }

    @When("I send HTTP request for product comment")
    public void userSendRequestForProductComments() {
        product.requestComment();
    }

    @And("I receive valid data for product comment")
    public void userReceiveValidDataForProductComments() {
        product.receiveDataComment();
    }

    // POST CREATE CATEGORY //
    @Given("I set endpoint for categorry")
    public void userSetEndpointForKategori() {
        productCate.endpointCategory();
    }
    @And("I success login with valid account")
    public void successLoginCategory(){}


    @When("I input the token authorization")
    public void tokenAuthorizeCate(){}
    @And("I send request to endpoint category")
    public void userSendRequestToEndpointKategori() {
        productCate.sendRequestCategory();
    }
    @Then("get status code 200 product category")
    public void statusCodeCate(){

    }
    @And("I saw new category response")
    public void userSeeNewKategoriResponse() {
        productCate.categoryResponse();
    }

    // GET ALL CATEGORIES OF PRODUCT //
    @When("Iam send request categorry")
    public void userSendRequestKategori() {
        productCate.sendCategoryREQ();
    }

    @And("I see all category")
    public void userSeeAllKategori() {
        productCate.seeAllKategori();
    }
}