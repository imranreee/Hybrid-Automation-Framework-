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
import repository.local_repo.db_model.UserLoginDBModel;
import repository.remote_repo.request_repo.EmployeeRegPostReqModel;
import repository.remote_repo.response_repo.EmployeeRegPostRespModel;

import java.sql.ResultSet;
import java.sql.SQLException;

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
    public void itWillReturnCreatedData() throws SQLException, ClassNotFoundException {
        EmployeeRegPostRespModel employeeRegPostRespModel = gson.fromJson(createdEmployeeResponse.getBody().asString(), EmployeeRegPostRespModel.class);
        System.out.println("The text responses");
        System.out.println("******************");
        System.out.println(employeeRegPostRespModel.getJob());
        System.out.println(employeeRegPostRespModel.getName());
        System.out.println(employeeRegPostRespModel.getId());
        System.out.println("*******************");

        Assert.assertEquals(employeeRegPostRespModel.getName(),employeeRegPostReqModel.getName());
        Assert.assertEquals(employeeRegPostRespModel.getJob(),employeeRegPostReqModel.getJob());


        ResultSet rs =  DBManager.executeQueries("select * from qa_test.user_loign where user_loign.id="+1+"");

        while (rs.next()){

            UserLoginDBModel dbModel = new UserLoginDBModel();

            dbModel.setId(rs.getInt("id"));
            dbModel.setJob(rs.getString("job"));
            dbModel.setNewName(rs.getString("name"));
            System.out.println(dbModel.getId());
            System.out.println(dbModel.getJob());
            System.out.println(dbModel.getNewName());

            //System.out.println(rs.getString(2));

        }


        /*while (rs.next()){

            UserLoginDBModel dbModel = new UserLoginDBModel();

            System.out.println((rs.getString(2)).getClass().getSimpleName());
           String name = rs.getString(2);
            System.out.println("my name is ....."+name);
            dbModel.setNewName(String.valueOf(name.toString()));
            System.out.println("does print"+dbModel.getNewName());




        }*/

    }
}
