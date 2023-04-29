import core.ExcelReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.*;
import pages.RegisterPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HYRTest {
    public  WebDriver driver;
    public RegisterPage regPage;
    protected String baseUrl = "https://www.hyrtutorials.com/p/add-padding-to-containers.html";
    @Parameters("browser")
    @BeforeMethod

    public void beforeTest(@Optional String browser) {
        // If the browser is Firefox, then do this
        if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(new FirefoxProfile());
            options.addPreference("dom.webnotifications.enabled", false);
            options.addPreference("geo.enabled", true);
            options.addPreference("geo.prompt.testing",true);
            options.addPreference("geo.prompt.testing.allow",true);
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(options);

        } else if (browser.equalsIgnoreCase("chrome") || browser.equalsIgnoreCase("")) {
            //Initialize the chrome driver
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            Map<String, Object> profile = new HashMap<String, Object>();
            Map<String, Integer> contentSettings = new HashMap<String, Integer>();

            // SET CHROME OPTIONS
            // 0 - Default, 1 - Allow, 2 - Block
            contentSettings.put("notifications", 2);
            contentSettings.put("geolocation", 2);
            profile.put("managed_default_content_settings", contentSettings);
            prefs.put("profile", profile);
            options.setExperimentalOption("prefs", prefs);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
    }

    @BeforeMethod
    public void test() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.manage().window().maximize();
        regPage = new RegisterPage(driver);
    }

    @DataProvider(name = "data_provider")
    public Object[][] dpMethod() throws IOException {
        ExcelReader file = new ExcelReader();
        Object data[][]=  file.excelReader();
        return data;
    }

    @Test(dataProvider = "data_provider")
    public void register(String fName, String lName, String email, String pw, String rePas, String successTitle){
        regPage.enterFirstName(fName);
        regPage.enterLastName(lName);

        regPage.enterEmail(email);

        regPage.enterPassword(pw);
        regPage.reEnterPassword(rePas);

        regPage.clickRegBtn();
        regPage.validateRegTitle(successTitle);
    }

    @AfterMethod
    public void endTest(){
        driver.quit();
    }
}
