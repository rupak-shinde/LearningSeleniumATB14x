package com.thetestingacademy.ex02_Selenium_Basics;

import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium002_BasicSelenium {
@Test
    public void test_basic(){
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
    }
}
