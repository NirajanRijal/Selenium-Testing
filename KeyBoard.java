package org.example.testngtests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.concurrent.TimeUnit;


public class KeyBoard {

    WebDriver driver;

    @BeforeTest
    public void beforetest() {
        //WebDriverManager.chromedriver().clearDriverCache().setup();
        System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\Desktop\\SeliniumFrameworkITsutra\\SeliniumFramework\\SelinuimPractice\\src\\test\\resources\\driver\\chromedriver.exe" );
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("--start-maximized");
        ops.addArguments("--incognito");
        ops.setExperimentalOption("useAutomationExtension", false);
        ops.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver = new ChromeDriver(ops);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void Keypress() throws InterruptedException {
        driver.get("https://www.flipkart.com/");
        Actions a=new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"))).click().keyDown(Keys.SHIFT).sendKeys("Perfume").perform();
        Thread.sleep(2000);
        a.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).perform();
    }



}
