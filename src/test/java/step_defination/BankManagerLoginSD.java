package step_defination;

import core.WebSettings;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BankAccountCreate;

public class BankManagerLoginSD extends WebSettings{
    public WebDriver driver;
    BankAccountCreate bac;
    //WebSettings ws = new WebSettings();

    @Given("User has base URL")
    public void userHasBaseURL() {
        driver = WebSettings.appUpAndRun();
    }

    @When("User will click on Add Customer button")
    public void userWillClickOnAddCustomerButton() {
        bac = new BankAccountCreate(driver);
        bac.clickOnBankManagerLogin();
        bac.clickOnAddCustomer();
    }

    @And("Enter {string} and {string} and {string}")
    public void enterFirstNameAndLastNameAndPostCode(String firstName, String lastName, String postCode) {
        bac.enterFirstName(firstName);
        bac.enterFirstName(lastName);
        bac.enterFirstName(postCode);
    }

    @And("Click on Add Customer button")
    public void clickOnAddCustomerButton() {
        bac.clickOnAddCustomerBtn();
    }

    @Then("Customer will be added successfully")
    public void customerWillBeAddedSuccessfully() {
        System.out.println("Hi");
    }
}
