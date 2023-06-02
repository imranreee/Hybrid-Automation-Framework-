package core;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AndroidSettings {
    DesiredCapabilities dc = new DesiredCapabilities();

    AndroidDriver driver = null;
    /*AppiumDriverLocalService appiumService;
    String appiumServiceUrl;*/

    public AndroidDriver upAndRunApp() throws Exception {
        /*appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.start();
        appiumServiceUrl = appiumService.getUrl().toString();
        appiumService.clearOutPutStreams();*/

        dc.setCapability(MobileCapabilityType.UDID, "R58N8583SXK");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung");
        dc.setCapability("platformVersion", "12.0");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        Thread.sleep(6000);
        driver  = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);

        return driver;
    }
}
