package com.example.appiumtestingandroid;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumNativeTests {

    private static AndroidDriver driver;

    @BeforeSuite
    public static void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.VERSION, "8.1.0");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android SDK built for x86");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        capabilities.setCapability(MobileCapabilityType.ORIENTATION, "LANDSCAPE");
        capabilities.setCapability(MobileCapabilityType.APP, "https://raw.githubusercontent.com/afollestad/material-dialogs/master/sample/sample.apk");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        System.out.println("Device orientation: " + driver.getOrientation());
        System.out.println("Current activity: " + driver.currentActivity());
    }

    @AfterMethod
    public void restartApp(){
        // Restart the app before each test case
        driver.resetApp();
    }

    @Test()
    public void pressFirstButton(){
        driver.findElementById("com.afollestad.materialdialogssample:id/basic").click();
    }

    @Test()
    public void pressSecondButton(){
        driver.findElementById("com.afollestad.materialdialogssample:id/basic_titled").click();
    }

    @AfterSuite
    public static void tearDown() {
        driver.quit();
    }
}