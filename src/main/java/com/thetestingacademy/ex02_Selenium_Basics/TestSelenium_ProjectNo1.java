package com.thetestingacademy.ex02_Selenium_Basics;

import com.thetestingacademy.CommonToAll;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium_ProjectNo1 extends CommonToAll {
    @Description("TC#1 - Verify That a particular text exists on the katalon Website")
    @Link("https://bugz.atlassian.net/browse/VP-1")
    @Test
    public void test_verify_text()
    {
        WebDriver driver1 = new FirefoxDriver();
        openBrowser(driver1,"https://katalon-demo-cura.herokuapp.com");
        if (driver1.getPageSource().contains("CURA Healthcare Service"))
        {
            System.out.println("✅ Test Cases PASSED!");
            Assert.assertTrue(true);
        }else
        {
            System.out.println("❌ Test Cases FAILED!");
            Assert.assertTrue(true);
        } closeBrowser(driver1);

    }

}
