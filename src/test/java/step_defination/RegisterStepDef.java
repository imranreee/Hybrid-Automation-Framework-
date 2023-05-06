package step_defination;

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
    protected String baseUrl = "https://www.hyrtutorials.com/p/add-padding-to-containers.html";
    By btnReset = By.xpath("//button[text()='Reset']");

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
        driver.get(baseUrl);
        driver.manage().window().maximize();
        regPage = new RegisterPage(driver);

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
        regPage.clickOnReset();
        Thread.sleep(3000);
    }

    @Then("Fields will be blank")
    public void fieldsWillBeBlank() {
        System.out.println("lol");
    }
}
