package com.thetestingacademy.ex02_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium14_Close_VS_quit {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
      //  driver.get("https://bing.com");
        Thread.sleep(5000);

       // driver.close();
        // Close - Will close the current tab, not the session (not the all tabs)
        // Session id !=null

        driver.quit();
        // It will close all the tabs. - Session id == null
    }
}
