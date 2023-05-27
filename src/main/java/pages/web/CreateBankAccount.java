package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
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
    By btnProcess = By.xpath("//button[@type='submit']");
    By dropCustomer = By.xpath("//select[@id='userSelect']");
    By dropCurrency = By.xpath("//select[@id='currency']");
    By selectCustomer = By.xpath("//option[@value='6']");
    By selectDollar = By.xpath("//option[@value='Dollar']");


    public CreateBankAccount(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS) ;
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

    public void clickOpenAccount(){
        driver.findElement(btnOpenAccount).click();

    }

    public void clickCustomerDropDown(){
        driver.findElement(dropCustomer).click();
    }

    public void selectCustomer(){
        driver.findElement(selectCustomer).click();

    }

    public void clickCurrencyDropDown(){
        driver.findElement(dropCurrency).click();
    }

    public void selectCurrency(){
        driver.findElement(selectDollar).click();
    }

    public void clickProcessBtn(){
        driver.findElement(btnProcess).click();
    }

    public void validateAccountCreated(String expectedAlertText){
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, expectedAlertText);
    }
}
