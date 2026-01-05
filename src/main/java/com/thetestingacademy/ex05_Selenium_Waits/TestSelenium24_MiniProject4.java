package com.thetestingacademy.ex05_Selenium_Waits;

import com.thetestingacademy.CommonToAll;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium24_MiniProject4 extends CommonToAll {

    @Test
    public  void testCloseModal(){

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.makemytrip.com");

        waitForVisibility(driver,5,"//span[@data-cy=\"closeModal\"]");

        WebElement closePopUp = driver.findElement(By.xpath("//span[@data-cy=\"closeModal\"]"));

        closeBrowser(driver);
    }
}
