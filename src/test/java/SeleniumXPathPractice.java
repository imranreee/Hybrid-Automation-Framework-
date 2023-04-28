

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SeleniumXPathPractice {
    public static WebDriver driver;

    public static void main(String[] args){
        String currentDir = System.getProperty("user.dir");
        String path = currentDir +"\\src\\test\\resources\\chromedriver.exe";
        System.out.println(path);

        System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions options = new ChromeOptions();

        //To allow pop up 1 and to block 2, default 0
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        driver.manage().window().maximize();

        By firstName = By.xpath("//label[text()='Last Name']/preceding-sibling::input[@name=\"name\"]");
        By lastName = By.xpath("//label[text()='Last Name']/following-sibling::input[@name=\"name\"]");
        By email = By.xpath("//label[text()='Email']/following-sibling::input[@type=\"text\"]");
        By password = By.xpath("//label[text()='Password']//following::input[@type=\"password\"][1]");
        By reEnterPassword = By.xpath("//label[text()='Password']//following::input[@type=\"password\"][2]");
        By regBtn = By.xpath("//button[text()='Register']");

        driver.findElement(firstName).sendKeys("MD AL");
        driver.findElement(lastName).sendKeys("IMRAN");
        driver.findElement(email).sendKeys("imran@test.com");
        driver.findElement(password).sendKeys("Abc@1234");
        driver.findElement(reEnterPassword).sendKeys("Abc@1234");

        driver.findElement(regBtn).click();

        driver.quit();
    }
}
