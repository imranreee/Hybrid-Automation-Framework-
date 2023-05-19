package step_defination;

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

import static core.CoreConstantHelper.base_url;
import static core.FilePathHelper.employeeRgePostAPIPath;

public class APIEmployeeRegPostSD {
    private Gson gson = new Gson();
    private String reqModel;
    Response createdEmployeeResponse;

    EmployeeRegPostReqModel employeeRegPostReqModel;
    String url;
    @Given("User has the API {string}")
    public void userHasTheAPIPath(String user) {
        url = base_url + user;
    }

    @When("User hit {string} and {string}")
    public void userHitNameAndJobTitle(String name, String jobTitle) {
        JSONObject requestBody = new FileHandleHelper().readJsonFile(employeeRgePostAPIPath);
        employeeRegPostReqModel = new Gson().fromJson(requestBody.toJSONString(), EmployeeRegPostReqModel.class);
        employeeRegPostReqModel.setName(name);
        employeeRegPostReqModel.setJob(jobTitle);
        reqModel = gson.toJson(employeeRegPostReqModel);
    }

    @And("Call the API with body")
    public void callTheAPIWithBody() {
        createdEmployeeResponse = APIHandler.postCall(HeaderFormatHelper.commonHeaders(), reqModel, url);
        System.out.println(createdEmployeeResponse.body().asString());
    }

    @Then("It will return created data")
    public void itWillReturnCreatedData() {
        EmployeeRegPostRespModel employeeRegPostRespModel = gson.fromJson(createdEmployeeResponse.getBody().asString(), EmployeeRegPostRespModel.class);
        System.out.println(employeeRegPostRespModel.getJob());
        System.out.println(employeeRegPostRespModel.getName());
        System.out.println(employeeRegPostRespModel.getId());
        Assert.assertEquals(employeeRegPostRespModel.getName(),employeeRegPostReqModel.getName());

    }
}
