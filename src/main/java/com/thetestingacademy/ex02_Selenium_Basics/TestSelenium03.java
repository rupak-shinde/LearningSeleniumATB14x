package com.thetestingacademy.ex02_Selenium_Basics;

import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium03 {
    public static void main(String[] args) {
        FirefoxDriver driver = new FirefoxDriver();
        // new FirefoxDriver() :- This start of selenium Session
        // Session - Fresh copy of browser is started
        // Post req to the server - firefox driver

        driver.get("https://www.google.com/");

        // command number 2 - post req to give to the driver navigate to a URL

    }
}

