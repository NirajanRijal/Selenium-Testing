package org.example.testngtests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Assertion{
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        // Setup WebDriver
        WebDriverManager.chromedriver().clearDriverCache().setup();
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("--start-maximized");
        ops.addArguments("--incognito");
        ops.setExperimentalOption("useAutomationExtension", false);
        ops.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver = new ChromeDriver(ops);
        // Implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Navigate to the URL
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void test1() {
        // Find the logo element
        WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
        // Assertion
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void test2() {
        // Get the page title
        String pageTitle = driver.getTitle();
        // Assertion
        Assert.assertEquals(pageTitle, "OrangeHRM", "Title not matched");
    }

    @AfterTest
    public void afterTest() {
        // Quit the WebDriver after all tests are done
        driver.quit();
    }
}
