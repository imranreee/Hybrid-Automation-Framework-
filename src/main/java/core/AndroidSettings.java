package core;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AndroidSettings {
    DesiredCapabilities dc = new DesiredCapabilities();

    AndroidDriver driver = null;

    public AndroidDriver upAndRunApp() throws Exception {
        dc.setCapability(MobileCapabilityType.UDID, "127.0.0.1:21503");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 11");
        dc.setCapability("platformVersion", "7.1.2");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        Thread.sleep(6000);
        driver  = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);

        return driver;
    }
}
