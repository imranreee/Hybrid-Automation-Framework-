package step_defination.api;

import com.google.gson.Gson;
import core.APIHandler;
import core.HeaderFormatHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import repository.remote_repo.response_repo.UserListGetResponseModel;

import static core.CoreConstantHelper.API_BASE_URL;

public class APIGetListOfUsersStepdefs {

    Response usrListResponse;
    private Gson gson = new Gson();
    String url;

    @Given("User has end point of usr list {string}")
    public void userHasEndPointOfUsrListEndPoint(String endPint) {
        url = API_BASE_URL + endPint;
        System.out.println(url);
    }

    @When("User will hit url and header")
    public void userWillHitUrlAndHeader() {
        usrListResponse = APIHandler.getCall(HeaderFormatHelper.commonHeaders(), url);
        System.out.println(usrListResponse);
    }

    @And("Validate the response code of list user")
    public void validateTheResponseCodeOfListUser() {
        int resCode = usrListResponse.getStatusCode();
        System.out.println("The Code is:" +resCode);
    }

    @Then("User will get the response")
    public void userWillGetTheResponse() {
        System.out.println("******The JSor Response ********");
        System.out.println(usrListResponse.getBody().toString());
        System.out.println("***********************************");

        UserListGetResponseModel userListGetResponseModel = gson.fromJson(usrListResponse.getBody().asString(), UserListGetResponseModel.class);
        System.out.println("===> The text responses <===");
        System.out.println(userListGetResponseModel.getPage());
        System.out.println(userListGetResponseModel.getPer_page());
        System.out.println(userListGetResponseModel.getTotal());
        System.out.println(userListGetResponseModel.getTotal_pages());
        System.out.println("*****************************");
    }
}
