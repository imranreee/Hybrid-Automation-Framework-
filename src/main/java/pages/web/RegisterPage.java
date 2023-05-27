package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterPage {
    public static WebDriver driver;
    By titleRegister = By.xpath("//h1[text()='Register']");
    By linkSignIn = By.xpath("//a[text()='Sign in into account']");
    By inputFirstName = By.xpath("//label[text()='Last Name']/preceding-sibling::input[@name=\"name\"]");
    By inputLastName = By.xpath("//label[text()='Last Name']/following-sibling::input[@name=\"name\"]");
    By inputEmail = By.xpath("//label[text()='Email']/following-sibling::input[@type=\"text\"]");
    By inputPassword = By.xpath("//label[text()='Password']//following::input[@type=\"password\"][1]");
    By inputReEnterPassword = By.xpath("//label[text()='Password']//following::input[@type=\"password\"][2]");
    By btnRegister = By.xpath("//button[text()='Register']");
    By btnReset = By.xpath("//button[text()='Reset']");

    public RegisterPage(WebDriver driver){
        RegisterPage.driver = driver;
    }

    public void validateRegTitle(String expectedTitle){
        String actualRegTitle = driver.findElement(titleRegister).getText();
        Assert.assertEquals(actualRegTitle, expectedTitle);
    }

    public void enterFirstName(String firstName){
        driver.findElement(inputFirstName).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        driver.findElement(inputLastName).sendKeys(lastName);
    }

    public void enterEmail(String email){
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void enterPassword(String password){
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void reEnterPassword(String rePassword){
        driver.findElement(inputReEnterPassword).sendKeys(rePassword);
    }
    public void clickRegBtn(){
        driver.findElement(btnRegister).click();
    }

    public void clickOnReset(){
        driver.findElement(btnReset).click();
    }

}
