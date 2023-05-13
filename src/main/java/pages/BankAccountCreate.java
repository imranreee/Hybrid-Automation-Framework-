package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BankAccountCreate {
    public static WebDriver driver;

    By btnLogin = By.xpath("//button[text()='Customer Login']");
    By btnBankManagerLogin = By.xpath("//button[text()='Bank Manager Login']");
    By btnAddCustomer = By.xpath("//button[@ng-class='btnClass1']");
    By btnOpenAccount = By.xpath("//button[@ng-class='btnClass2']");
    By btnCustomers = By.xpath("//button[@ng-class='btnClass3']");
    By inputFirstName = By.xpath("//input[@ng-model='fName']");
    By inputLastName = By.xpath("//input[@ng-model='lName']");
    By inputPostCode = By.xpath("//input[@ng-model='postCd']");
    By btnAddCustomerForm = By.xpath("//button[text()='Add Customer']");


    public BankAccountCreate(WebDriver driver){
        BankAccountCreate.driver = driver;
    }

    public void validateRegTitle(String expectedTitle){

    }

    public void enterFirstName(String firstName){

    }


}
