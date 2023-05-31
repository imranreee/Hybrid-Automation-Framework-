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
import repository.remote_repo.request_repo.EmployeeRegPostReqModel;
import repository.remote_repo.response_repo.EmployeeRegPostRespModel;

import static core.CoreConstantHelper.API_BASE_URL;
import static core.FilePathHelper.employeeRgePostJSonFIlePath;

public class APIPostEmployeeRegStepDefs {
    private Gson gson = new Gson();
    private String reqModel;
    Response createdEmployeeResponse;

    EmployeeRegPostReqModel employeeRegPostReqModel;
    String url;
    @Given("User has the API {string}")
    public void userHasTheAPIPath(String endPoint) {
        url = API_BASE_URL + endPoint;
    }

    @When("User hit {string} and {string}")
    public void userHitNameAndJobTitle(String name, String jobTitle) {
        JSONObject requestBody = new FileHandleHelper().readJsonFile(employeeRgePostJSonFIlePath);
        employeeRegPostReqModel = new Gson().fromJson(requestBody.toJSONString(), EmployeeRegPostReqModel.class);
        employeeRegPostReqModel.setName(name);
        employeeRegPostReqModel.setJob(jobTitle);
        reqModel = gson.toJson(employeeRegPostReqModel);
    }

    @And("Call the API with body")
    public void callTheAPIWithBody() {
        createdEmployeeResponse = APIHandler.postCall(HeaderFormatHelper.commonHeaders(), reqModel, url);
        System.out.println("The JSon response");
        System.out.println("*****************************");
        System.out.println(createdEmployeeResponse.body().asString());
        System.out.println("*****************************");
    }

    @Then("It will return created data")
    public void itWillReturnCreatedData() {
        EmployeeRegPostRespModel employeeRegPostRespModel = gson.fromJson(createdEmployeeResponse.getBody().asString(), EmployeeRegPostRespModel.class);
        System.out.println("The text responses");
        System.out.println("******************");
        System.out.println(employeeRegPostRespModel.getJob());
        System.out.println(employeeRegPostRespModel.getName());
        System.out.println(employeeRegPostRespModel.getId());
        System.out.println("*******************");

        Assert.assertEquals(employeeRegPostRespModel.getName(),employeeRegPostReqModel.getName());
        Assert.assertEquals(employeeRegPostRespModel.getJob(),employeeRegPostReqModel.getJob());

    }
}
