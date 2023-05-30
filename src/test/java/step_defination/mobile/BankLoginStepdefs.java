package step_defination.mobile;

import core.AndroidSettings;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.android.BankLogin;

public class BankLoginStepdefs {
    public  AndroidDriver driver;
    BankLogin bl;
    @Given("User has apk")
    public void userHasApk() throws Exception {
        AndroidSettings as = new AndroidSettings();
        driver = as.upAndRunApp();
    }

    @When("User will enter {string} and {string}")
    public void userWillEnterUsernameAndPassword (String username, String password) throws Exception {
        bl = new BankLogin(driver);
        bl.enterUsername(username);
        bl.enterPassword(password);
    }

    @And("Click on Login button")
    public void clickOnLoginButton() throws Exception{
        bl.clickLogin();
    }

    @Then("Logged in successfully")
    public void loggedInSuccessfully() throws Exception{
        System.out.println("lol");
    }
}
