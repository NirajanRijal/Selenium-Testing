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

public class StaticDrop {

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
    public void Staticdrop() {
        driver.get("https://www.irctc.co.in/nget/train-search");
        driver.findElement(By.xpath("//span[@class='ng-tns-c65-11 ui-dropdown-label ui-inputtext ui-corner-all ng-star-inserted']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Vistadome AC (EV)']")).click();
        List<WebElement> l= driver.findElements(By.xpath("//div[@class=\"col-xs-12 remove-padding\"]"));
        for(WebElement i:l)
        {
            System.out.println(i.getText());
        }
        driver.findElement(By.xpath("//label[@for='dateSpecific']")).click();
    }
}
