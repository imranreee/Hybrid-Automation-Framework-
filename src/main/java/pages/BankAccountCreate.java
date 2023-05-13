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

    public void clickOnBankManagerLogin(){
        driver.findElement(btnBankManagerLogin).click();
    }

    public void clickOnAddCustomer(){
        driver.findElement(btnBankManagerLogin).click();
    }

    public void enterFirstName(String firstName){
        driver.findElement(inputFirstName).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        driver.findElement(inputLastName).sendKeys(lastName);
    }

    public void enterPostCode(String postCode){
        driver.findElement(inputPostCode).sendKeys(postCode);
    }

    public void clickOnAddCustomerBtn(){
        driver.findElement(btnAddCustomerForm).click();
    }


}
