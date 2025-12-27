package com.thetestingacademy.ex04_Selenium_XPATH;

import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import com.thetestingacademy.CommonToAll;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium21_MiniProject_3 extends CommonToAll {
    @Owner("Pramod")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that with valid email, pass, appointment page is loaded")
    @Test
    public void test_katalon_login() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        openBrowser(driver,"https://katalon-demo-cura.herokuapp.com");

        WebElement make_appointment_button_Xpath = driver.findElement(By.xpath("//a[contains(text(),\"Make Appointment\")]"));
        make_appointment_button_Xpath.click();

        List<WebElement> username_inputs = driver.findElements(By.xpath("//input[@placeholder='Username']"));
        username_inputs.get(1).sendKeys("John Doe");

        List<WebElement> password_inputs = driver.findElements(By.xpath("//input[@placeholder='Password']"));
        password_inputs.get(1).sendKeys("ThisIsNotAPassword");

        WebElement login_input_box = driver.findElement(By.xpath("//button[text()='Login']"));
        login_input_box.click();

        customWait(3000);

        WebElement h2 = driver.findElement(By.xpath("//h2[text()='Make Appointment']"));
        Assert.assertEquals(h2.getText(),"Make Appointment");
        Assert.assertTrue(h2.isDisplayed());

        closeBrowser(driver);

    }
}
