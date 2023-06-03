package step_defination.api;

import com.google.gson.Gson;
import core.APIHandler;
import core.DBManager;
import core.FileHandleHelper;
import core.HeaderFormatHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import repository.local_repo.db_model.UserDBModel;
import repository.remote_repo.request_repo.RegPostRequestModel;
import repository.remote_repo.response_repo.RegPostResponseModel;

import java.sql.ResultSet;
import java.sql.SQLException;

import static core.CoreConstantHelper.API_BASE_URL;
import static core.FilePathHelper.regPostJsonFilePath;

public class APIPostRegStepdefs {
    private Gson gson = new Gson();
    private String reqModel;
    Response createdUserResponse;

    RegPostRequestModel regPostRequestModel;
    String url;

    UserDBModel dbModel;
    @Given("User has the registration API {string}")
    public void userHasTheRegistrationAPIApiPath(String endPoint) {
        url = API_BASE_URL + endPoint;
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
    public void validateTheResponse() throws SQLException, ClassNotFoundException {
        RegPostResponseModel regPostResponseModel = gson.fromJson(createdUserResponse.getBody().asString(), RegPostResponseModel.class);
        System.out.println("===> The text responses <===");
        System.out.println(regPostResponseModel.getId());
        System.out.println(regPostResponseModel.getToken());
        System.out.println("*****************************");

        ResultSet rs =  DBManager.executeQueries("select * from qa_test.user_loign limit 1");

        while (rs.next()){

            dbModel.setId(rs.getInt("id"));
            dbModel.setJob(rs.getString("job"));
            dbModel.setNewName(rs.getString("name"));
            System.out.println(dbModel.getId());
            System.out.println(dbModel.getJob());
            System.out.println(dbModel.getNewName());
        }
    }
}
