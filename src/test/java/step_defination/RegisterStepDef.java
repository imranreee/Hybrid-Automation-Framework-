package step_defination;

import core.WebSettings;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.RegisterPage;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RegisterStepDef {
    public static WebDriver driver1;
    public  WebDriver driver;
    public RegisterPage regPage;
    public WebSettings webSettings;
    @Given("user has base url")
    public void userHasBaseUrl() {
        regPage = new RegisterPage(driver);
        webSettings = new WebSettings();
        webSettings.appUpAndRun();
    }

    @When("user will enter {string} and {string} and {string}")
    public void userWillEnterFirstNameAndLastNameAndEmailAddress(String firstName, String lastName, String emailAddress) {
        regPage.enterFirstName(firstName);
        regPage.enterLastName(lastName);
        regPage.enterEmail(emailAddress);
    }

    @And("enter {string} and {string}")
    public void enterPasswordAndReEnterPassword(String password, String reEnterPassword) {
        regPage.enterPassword(password);
        regPage.reEnterPassword(reEnterPassword);
    }

    @And("click on the Register button")
    public void clickOnTheRegisterButton() {
        regPage.clickRegBtn();
    }

    @Then("User will register successfully")
    public void userWillRegisterSuccessfully() {
        regPage.validateRegTitle("Register");
        driver1=driver;

    }

    @When("User will click on Reset button")
    public void userWillClickOnResetButton() throws Exception {
        regPage = new RegisterPage(driver1);
        System.out.println("Executed");
        regPage.clickOnReset();
        Thread.sleep(3000);
    }

    @Then("Fields will be blank")
    public void fieldsWillBeBlank() {
        System.out.println("lol");
    }
}
