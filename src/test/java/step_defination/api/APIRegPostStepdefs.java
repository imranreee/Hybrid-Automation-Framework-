package step_defination.api;

import com.google.gson.Gson;
import core.APIHandler;
import core.FileHandleHelper;
import core.HeaderFormatHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import repository.remote_repo.request_repo.RegPostRequestModel;
import repository.remote_repo.response_repo.RegPostResponseModel;

import static core.CoreConstantHelper.BASE_URL;
import static core.FilePathHelper.regPostJsonFilePath;

public class APIRegPostStepdefs {
    private Gson gson = new Gson();
    private String reqModel;
    Response createdUserResponse;

    RegPostRequestModel regPostRequestModel;
    String url;
    @Given("User has the registration API {string}")
    public void userHasTheRegistrationAPIApiPath(String endPoint) {
        url = BASE_URL + endPoint;
        System.out.println("The Full URL is: " +url);
    }

    @When("User will send {string} and {string}")
    public void userWillSendEmailAndPassword(String email, String password) {
        JSONObject requestBody = new FileHandleHelper().readJsonFile(regPostJsonFilePath);
        regPostRequestModel = new Gson().fromJson(requestBody.toJSONString(), RegPostRequestModel.class);
        regPostRequestModel.setEmail(email);
        regPostRequestModel.setPassword(password);
        reqModel = gson.toJson(regPostRequestModel);
    }

    @And("Validate the response code")
    public void validateTheResponseCode() {
        createdUserResponse = APIHandler.postCall(HeaderFormatHelper.commonHeaders(), reqModel, url);
        int actualStatusCode = createdUserResponse.getStatusCode();
        System.out.println("Status Code: " +actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);
    }

    @And("Get the API response")
    public void getTheAPIResponse() {


        System.out.println("The JSon response");
        System.out.println("*****************************");
        System.out.println(createdUserResponse.body().asString());

        System.out.println("*****************************");
    }

    @Then("Validate the response")
    public void validateTheResponse() {
        RegPostResponseModel regPostResponseModel = gson.fromJson(createdUserResponse.getBody().asString(), RegPostResponseModel.class);
        System.out.println("===> The text responses <===");
        System.out.println(regPostResponseModel.getId());
        System.out.println(regPostResponseModel.getToken());
        System.out.println("*****************************");
    }
}
