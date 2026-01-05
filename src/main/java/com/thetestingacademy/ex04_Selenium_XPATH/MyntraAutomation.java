package com.thetestingacademy.ex04_Selenium_XPATH;
//        ----------------------------------------------------------------
//        PART 1: UI AUTOMATION TASK (MYNTRA SCENARIO)
//        ----------------------------------------------------------------
//
//        Scenario:
//        1. Open Myntra website.
//        2. Search for "Bag".
//        3. Click on the 7th result (requires List handling).
//        4. Switch to the new tab (product opens in a new window).
//        5. Click "Add to Cart".
//        6. Go to Cart and click "Remove".
//        7. Handle the confirmation popup.
//        [JAVA + SELENIUM CODE SOLUTION]

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class MyntraAutomation {
    public static void main(String[] args) {
        // 1. Setup Driver

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            // Step 1: Open URL
            driver.get("https://www.myntra.com/");
            // Step 2: Search for 'Bag'
            driver.findElement(By.className("desktop-searchBar")).sendKeys("Bag" + Keys.ENTER);
            // Step 3: Click the 7th Result
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product-base")));
            List<WebElement> products = driver.findElements(By.className("product-base"));

            // List index starts at 0, so 7th item is index 6
            if(products.size() >= 7) {
                products.get(6).click();
            }
            // Step 4: SWITCH WINDOWS (Critical Step)
            // Myntra opens product in a new tab. Focus must be switched.

            String parentWindow = driver.getWindowHandle();
            Set<String> allWindows = driver.getWindowHandles();

            for(String window : allWindows) {
                if(!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                }
            }

            // Step 5: Add to Cart
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(text(),'ADD TO BAG')]"))).click();
            // Step 6: Go to Cart & Click Remove
            driver.findElement(By.className("desktop-cart")).click();

            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(text(),'REMOVE')]"))).click();

            // Step 7: Handle Popup (Modal Dialog)
            // Wait for the specific confirmation button inside the modal
            WebElement confirmRemove = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@class='inlinebuttonV2-base-action' and text()='REMOVE']")));
            confirmRemove.click();

            System.out.println("Test Passed: Item removed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // driver.quit();
        }

    }

}