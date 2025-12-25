package com.thetestingacademy.ex02_Selenium_Basics;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestSelenium04_Webdriver_Hierarchy {
    public static void main(String[] args) {
        // Webdriver hierarchy
        // SearchContext(I) -> (2) -> WebDriver(I)( ~10) -> RemoteWebDriver(C) (~15)
        //        //// -> ChromiumDriver(C) ~25 -> EdgeDriver(C) (~45)
        // SearchContext - Interface - findElement, and findElements - GGF
        // WebDriver - Interface - some incomplete functions - GF
        // RemoteWebDriver - Class- It also has some functions - F
        // ChromeDriver, FirefoxDriver, EdgeDriver, SafariDriver, InternetExplorerDriver  Class - S

//        SearchContext driver = new FirefoxDriver();
//        SearchContext driver1 = new EdgeDriver();
//        SearchContext driver2 = new ChromeDriver();

        WebDriver driver = new FirefoxDriver();
        RemoteWebDriver driver1 = new FirefoxDriver();
        FirefoxDriver driver2 = new FirefoxDriver();

        // Scenario
        // 1. Do want to run on chrome or edge?
        ChromeDriver driver3=new ChromeDriver();
     //   driver2=FirefoxDriver();

        // 2. Do you want to run on chrome then change edge?
        WebDriver driver4 = new ChromeDriver();
        driver4= new EdgeDriver();
        driver4 = new FirefoxDriver();

        // 3. Do you want to run on multiple browsers, AWS machine? 2%
        // RemoteWebDriver driver (with GRID) - Advance (last 2 sessions)

    }
}
