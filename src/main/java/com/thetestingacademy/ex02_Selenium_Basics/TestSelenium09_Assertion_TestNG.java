package com.thetestingacademy.ex02_Selenium_Basics;

import io.qameta.allure.Description;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium09_Assertion_TestNG {
    @Description("Open the URL")
    @Test
    public void test_Selenium01(){

        WebDriver driver = new FirefoxDriver();
        driver.get("https://google.com");

    }
}
