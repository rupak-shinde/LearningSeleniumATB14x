package com.thetestingacademy.ex02_Selenium_Basics;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium08_Maximize_Minimize {


        @Test
                public void test_1() throws InterruptedException {
            WebDriver driver = new FirefoxDriver();
            driver.get("https://google.com");

            driver.manage().window().maximize();
            //driver.manage().window().minimize();

            Thread.sleep(5000);
            Assert.assertEquals(driver.getTitle(),"Google");
            driver.quit();
        }

}
