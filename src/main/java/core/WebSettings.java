package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class WebSettings {
    protected WebDriver driver;
    String BASE_URL = "https://globalsqa.com/angularJs-protractor/BankingProject/";

    public void appUpAndRun(){
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

        driver.manage().window().maximize();
        driver.get(BASE_URL);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        System.out.println("Browser successfully up and run with "+BASE_URL);
    }
}
