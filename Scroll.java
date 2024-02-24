package org.example.testngtests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Scroll {
    WebDriver driver;

    @BeforeTest
    public void beforetest() {
        //WebDriverManager.chromedriver().clearDriverCache().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\SeliniumFrameworkITsutra\\SeliniumFramework\\SelinuimPractice\\src\\test\\resources\\driver\\chromedriver.exe");
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
    public void Scroll() throws InterruptedException {

        driver.get("https://mdbootstrap.com/docs/b4/jquery/tables/scroll/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //this is just a thread to see slightly slowly
        Thread.sleep(2000);
        js.executeScript("window.scroll(0,3050)");

        // Scrolling table
        Thread.sleep(2000);

        js.executeScript("document.querySelector(\"div[id='dtVerticalScrollExample_wrapper'] div[class='dataTables_scrollBody']\").scrollTop=300");

        //scroll table horizontally

        Thread.sleep(2000);
        js.executeScript("document.querySelector(\"div[style$='position: relative; overflow: auto; width: 100%;']\").scrollLeft=300");
    }
}
