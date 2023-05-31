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
import repository.remote_repo.request_repo.APIPostLoginReqModel;
import repository.remote_repo.response_repo.APIPostLoginRespModel;

import static core.CoreConstantHelper.API_BASE_URL;
import static core.FilePathHelper.POST_LOGIN_JSON_FILE_PATH;

public class APIPostLoginStepdefs {
    private Gson gson = new Gson();
    private String requestModel;

    Response loggedInResponse;

    APIPostLoginReqModel apiPostLoginReqModel;
    String url;



    @Given("User has {string} for single user")
    public void userHasEnd_pointForSingleUser(String endPoint) {
        url = API_BASE_URL + endPoint;
    }

    @When("User will enter {string} and {string} for login")
    public void userWillEnterEmailAndPasswordForLogin(String email, String password) {
        JSONObject requestBody = new FileHandleHelper().readJsonFile(POST_LOGIN_JSON_FILE_PATH);
        apiPostLoginReqModel = new Gson().fromJson(requestBody.toJSONString(), APIPostLoginReqModel.class);

        apiPostLoginReqModel.setEmail(email);
        apiPostLoginReqModel.setPassword(password);

        requestModel = gson.toJson(apiPostLoginReqModel);
    }

    @And("Post the request and validate the response code")
    public void postTheRequestAndValidateTheResponseCode() {
        loggedInResponse = APIHandler.postCall(HeaderFormatHelper.commonHeaders(), requestModel, url);

        int actualStatusCode = loggedInResponse.getStatusCode();
        System.out.println("Status Code: " +actualStatusCode);
        Assert.assertEquals(actualStatusCode, 200);
    }

    @And("Get the response body")
    public void getTheResponseBody() {
        System.out.println("The JSon response");
        System.out.println("*****************************");
        System.out.println(loggedInResponse.body().asString());
        System.out.println("*****************************");
    }

    @Then("Validate the response for login API")
    public void validateTheResponseForLoginAPI() {
        APIPostLoginRespModel apiPostLoginRespModel = gson.fromJson(loggedInResponse.getBody().asString(), APIPostLoginRespModel.class);
        System.out.println("===> The text responses <===");
        System.out.println(apiPostLoginRespModel.getToken());
        System.out.println("*****************************");
    }
}
