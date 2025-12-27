package com.thetestingacademy.ex04_Selenium_XPATH;

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

public class TestSelenium22_TTABank_Task extends CommonToAll {
    @Owner("Pramod")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that with valid email, pass, appointment page is loaded")
    @Test
    public void test_TTABank_login() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        openBrowser(driver,"https://tta-bank-digital-973242068062.us-west1.run.app/");

        customWait(2000);
        WebElement sign_up_input_button = driver.findElement(By.xpath("//button[text()='Sign Up']"));
        sign_up_input_button.click();

        customWait(2000);

        List<WebElement> username_inputs = driver.findElements(By.xpath("//input[@placeholder='John Doe']"));
        username_inputs.get(0).sendKeys("Rupak Shinde");

        List<WebElement> email_inputs = driver.findElements(By.xpath("//input[@placeholder='you@example.com']"));
        email_inputs.get(0).sendKeys("rupak.shinde@ttabank.com");

        List<WebElement> password_inputs = driver.findElements(By.xpath("//input[@type='password']"));
        password_inputs.get(0).sendKeys("Password@123");

        List<WebElement> create_account_buttons = driver.findElements(By.xpath("//button[normalize-space()='Create Account']"));
        create_account_buttons.get(0).click();

        customWait(3000);
        WebElement transfer_funds_button = driver.findElement(By.xpath("//button[text()='Transfer Funds']"));
        transfer_funds_button.click();

        WebElement manage_beneficiaries_button = driver.findElement(By.xpath("//button[text()='Manage Beneficiaries']"));
        manage_beneficiaries_button.click();

        List<WebElement> beneficiary_name_inputs = driver.findElements(By.xpath("//input[@placeholder='e.g. John Doe']"));
        beneficiary_name_inputs.get(0).sendKeys("Rupak Shinde");

        List<WebElement> bank_name_inputs = driver.findElements(By.xpath("//input[@placeholder='e.g. Citibank']"));
        bank_name_inputs.get(0).sendKeys("City Bank");

        List<WebElement> account_number_inputs = driver.findElements(By.xpath("//input[@placeholder='8-12 digits']"));
        account_number_inputs.get(0).sendKeys("123456789012");

        WebElement save_beneficiaries_button = driver.findElement(By.xpath("//button[text()='Save Beneficiary']"));
        save_beneficiaries_button.click();

        customWait(500);
        List<WebElement> toast =
                driver.findElements(By.xpath("//*[contains(text(),'added to beneficiaries.')]"));
        if (toast.size() > 0)
            System.out.println("✅ Beneficiary added successfully");

        Assert.assertTrue(toast.size() > 0, "Beneficiary was NOT added successfully!");

        customWait(1001);
        driver.quit();

        closeBrowser(driver);
}
}
