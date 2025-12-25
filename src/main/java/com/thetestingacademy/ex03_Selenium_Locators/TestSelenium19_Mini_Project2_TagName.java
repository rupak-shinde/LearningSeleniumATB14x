package com.thetestingacademy.ex03_Selenium_Locators;

import com.thetestingacademy.CommonToAll;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium19_Mini_Project2_TagName  extends CommonToAll {
    @Owner("Pramod")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("https://bugz.atlassian.net/browse/BUG-17")
    @Description("Verify that the error message comes with invalid email on signup page.")
    @Test
    public void vwo_free_trail_error_verify()
    {

        //      // <input class="W(100%) Py(14px)
//           input-text" placeholder="name@yourcompany.com"
//        type="email" id="page-v1-step1-email" name="email"
//        data-qa="page-su-step1-v1-email" required="">

        // <input class="Cur(p) Flxs(0) M(0) Pos(r) T(2px)"
        // type="checkbox" name="gdpr_consent_checkbox"
        // id="page-free-trial-step1-cu-gdpr-consent-checkbox"
        // value="true" data-qa="page-free-trial-step1-gdpr-consent-checkbox">

        //<div class="C(--color-red) Fz(--font-size-12) Trsp(--Op) Trsdu(0.15s) Op(0) invalid-input+Op(1)
        // invalid-reason">The email address you entered is incorrect.</div

        WebDriver driver = new ChromeDriver();
        openBrowser(driver,"https://app.vwo.com");

        WebElement a_tag_partial_match = driver.findElement(By.partialLinkText("trial"));
        a_tag_partial_match.click();;
        //System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("free-trial"));

        WebElement email = driver.findElement(By.id("page-v1-step1-email"));
        email.sendKeys("abc");

        WebElement checkbox_policy = driver.findElement(By.name("gdpr_consent_checkbox"));
        checkbox_policy.click();

        WebElement button_create_account = driver.findElement(By.tagName("button"));
        button_create_account.click();

        WebElement error_message = driver.findElement(By.className("invalid-reason"));
        Assert.assertEquals(error_message.getText(),"The email address you entered is incorrect.");

        closeBrowser(driver);

    }
}
