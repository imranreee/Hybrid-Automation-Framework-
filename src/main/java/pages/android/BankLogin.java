package pages.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class BankLogin {
    public AndroidDriver driver;
    By btnOk = By.xpath("//*[@text='OK']");
    By inputUsername = By.xpath("//*[@text='Username']");
    By inputPassword = By.xpath("//*[@text='Password']");
    By btnLogin = By.xpath("//*[@text='Login']");


    public BankLogin(AndroidDriver driver){
        this.driver = driver;
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS) ;
    }

    public void enterUsername(String username) throws Exception {
        Thread.sleep(3000);
        driver.findElement(inputUsername).sendKeys(username);
    }

    public void enterPassword(String password) throws Exception{
        Thread.sleep(1000);
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void clickLogin() throws Exception{
        Thread.sleep(1000);
        driver.findElement(btnLogin).click();
    }


}
