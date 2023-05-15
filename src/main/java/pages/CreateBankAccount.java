package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class CreateBankAccount {
    public WebDriver driver;

    By btnLogin = By.xpath("//button[text()='Customer Login']");
    By btnBankManagerLogin = By.xpath("//button[text()='Bank Manager Login']");
    By btnAddCustomer = By.xpath("//button[@ng-class='btnClass1']");
    By btnOpenAccount = By.xpath("//button[@ng-class='btnClass2']");
    By btnCustomers = By.xpath("//button[@ng-class='btnClass3']");
    By inputFirstName = By.xpath("//input[@ng-model='fName']");
    By inputLastName = By.xpath("//input[@ng-model='lName']");
    By inputPostCode = By.xpath("//input[@ng-model='postCd']");
    By btnAddCustomerForm = By.xpath("//button[text()='Add Customer']");


    public CreateBankAccount(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS) ;
    }

    public void clickOnBankManagerLogin(){
        driver.findElement(btnBankManagerLogin).click();
    }

    public void clickOnAddCustomer(){
        driver.findElement(btnAddCustomer).click();
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

    public void validateAlertText(String expectedAlertText){
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, expectedAlertText);
    }

    public void acceptAlertPopUp(){
        driver.switchTo().alert().accept();
    }


}
