package com.thetestingacademy.ex05_Selenium_Waits;

import io.qameta.allure.Description;
import org.junit.Test;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class TestSelenium22_Waits {
    @Description("Verify the Ebay Print the prices(iMac)")
    @Test
    public  void  test_verify_print_imac_Price(){
        EdgeDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://app.vwo.com");
    }
}
