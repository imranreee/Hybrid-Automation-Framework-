import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SingleBrowser {
    public static WebDriver driver;
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

        } else if (browser.equalsIgnoreCase("chrome") || browser == null) {
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

    @DataProvider(name = "data_provider")
    public Object[][] dpMethod() throws IOException {
        ExcelReader file = new ExcelReader();
        Object data[][]=  file.excelReader();
        return data;
    }

    @Test(dataProvider = "data_provider")
    public void test(String name, String price ) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://chaldal.com/");
        driver.manage().window().maximize();

        By searchFiled = By.xpath("//input[@name='search_term_string']");

        String productName =  name;
        driver.findElement(searchFiled).sendKeys(productName);
    }

    @AfterTest
    public void endTest(){
        driver.quit();
    }

}
