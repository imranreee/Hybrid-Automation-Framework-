package StepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pages.RegisterPage;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RegisterStepDef {
    public static WebDriver driver;
    //public RegisterPage regPage;
    protected String baseUrl = "https://www.hyrtutorials.com/p/add-padding-to-containers.html";

    By titleRegister = By.xpath("//h1[text()='Register']");
    By linkSignIn = By.xpath("//a[text()='Sign in into account']");
    By inputFirstName = By.xpath("//label[text()='Last Name']/preceding-sibling::input[@name=\"name\"]");
    By inputLastName = By.xpath("//label[text()='Last Name']/following-sibling::input[@name=\"name\"]");
    By inputEmail = By.xpath("//label[text()='Email']/following-sibling::input[@type=\"text\"]");
    By inputPassword = By.xpath("//label[text()='Password']//following::input[@type=\"password\"][1]");
    By inputReEnterPassword = By.xpath("//label[text()='Password']//following::input[@type=\"password\"][2]");
    By btnRegister = By.xpath("//button[text()='Register']");


    @Given("user has base url")
    public void userHasBaseUrl() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Integer> contentSettings = new HashMap<String, Integer>();

        contentSettings.put("notifications", 2);
        contentSettings.put("geolocation", 2);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        options.addArguments("--remote-allow-origins=*");

        options.setExperimentalOption("prefs", prefs);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        driver.manage().window().maximize();
        //regPage = new RegisterPage(driver);

    }

    @When("user will enter {string} and {string} and {string}")
    public void userWillEnterFirstNameAndLastNameAndEmailAddress(String firstName, String lastName, String emailAddress) {
        driver.findElement(inputFirstName).sendKeys(firstName);
        driver.findElement(inputLastName).sendKeys(lastName);
        driver.findElement(inputEmail).sendKeys(emailAddress);
    }

    @And("enter {string} and {string}")
    public void enterPasswordAndReEnterPassword(String password, String reEnterPassword) {
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(inputReEnterPassword).sendKeys(reEnterPassword);
    }

    @And("click on the Register button")
    public void clickOnTheRegisterButton() {
        driver.findElement(btnRegister).click();
    }

    @Then("User will register successfully")
    public void userWillRegisterSuccessfully() {
        String actualText = driver.findElement(titleRegister).getText();
        Assert.assertEquals(actualText, "Register");
    }


}
