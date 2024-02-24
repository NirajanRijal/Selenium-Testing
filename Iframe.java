package org.example.testngtests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Iframe {

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
    public void Ifram() {

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm");

        //switch to exact frame
        driver.switchTo().frame("iframeResult");

        //click try button now, firstly try without using above code to see

        driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();

        // click or dismiss alert

        driver.switchTo().alert().accept();

        //driver.switchTo().alert().dismiss();

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//a[@id='getwebsitebtn']")).click();

        List<WebElement> li=driver.findElements(By.tagName("iframe"));
        System.out.println("No. of frames in webpage="+li.size());

    }
}
