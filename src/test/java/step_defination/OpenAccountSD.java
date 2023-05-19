package step_defination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateBankAccount;

import static step_defination.BankManagerLoginSD.driver;

public class OpenAccountSD {
    CreateBankAccount bac;
    @When("User will click on Open Account")
    public void userWillClickOnOpenAccount() {
        bac = new CreateBankAccount(driver);
        bac.clickOpenAccount();
    }

    @And("User will select created customer from list")
    public void userWillSelectCreatedCustomerFromList() {
        bac.clickCustomerDropDown();
        bac.selectCustomer();
    }

    @And("User will select country from list")
    public void userWillSelectCountryFromList() {
        bac.clickCurrencyDropDown();
        bac.selectCurrency();
    }

    @And("User will click on Proceed button")
    public void userWillClickOnProceedButton() {
        bac.clickProcessBtn();
    }

    @Then("Account will be created successfully")
    public void accountWillBeCreatedSuccessfully() {
        bac.validateAccountCreated("Account created successfully with account Number :1016");
        bac.acceptAlertPopUp();
    }
}
