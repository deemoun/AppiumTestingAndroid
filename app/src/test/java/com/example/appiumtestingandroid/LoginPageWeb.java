package com.example.appiumtestingandroid;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class LoginPageWeb {

    private AndroidDriver driver;

    LoginPageWeb(AndroidDriver driver) {
        this.driver = driver;

    }
        public void typeUserName (){
            driver.findElement(By.id("m_login_email")).sendKeys("mylogin");
        }

        public void typeUserPassword (){
            driver.findElement(By.id("m_login_password")).sendKeys("mypassword");
        }

        public void clickLoginButton (){
            driver.findElement(By.name("login")).click();
        }


}
