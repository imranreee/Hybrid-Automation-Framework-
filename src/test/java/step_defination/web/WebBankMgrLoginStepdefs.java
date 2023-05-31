package step_defination.web;

import core.WebSettings;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.web.CreateBankAccount;

public class WebBankMgrLoginStepdefs {
    public static WebDriver driver;
    CreateBankAccount bac;

    @Given("User has base URL")
    public void userHasBaseURL() {
        WebSettings ws = new WebSettings();
        driver = ws.appUpAndRun();
    }

    @When("User will click on Bank manager loign button")
    public void userWillClickOnBankManagerLoignButton() {
        bac = new CreateBankAccount(driver);
        bac.clickOnBankManagerLogin();
    }

    @And("User will click on Add customer button")
    public void userWillClickOnAddCustomerButton() {
        bac.clickOnAddCustomer();
    }

    @And("Enter {string} and {string} and {string}")
    public void enterFirstNameAndLastNameAndPostCode(String firstName, String lastName, String postCode) {
        bac.enterFirstName(firstName);
        bac.enterLastName(lastName);
        bac.enterPostCode(postCode);
    }

    @And("Click on Add Customer button")
    public void clickOnAddCustomerButton() {
        bac.clickOnAddCustomerBtn();
    }

    @Then("Customer will be added successfully")
    public void customerWillBeAddedSuccessfully() {
        bac.validateAlertText("Customer added successfully with customer id :6");
        bac.acceptAlertPopUp();
    }
}
