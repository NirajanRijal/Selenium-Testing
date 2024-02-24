package org.example.testngtests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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

public class MouseHover {
    WebDriver driver;

    @BeforeTest
    public void beforetest() {
        String rootpath=System.getProperty("user.dir");
        //WebDriverManager.chromedriver().clearDriverCache().setup();
        System.setProperty("webdriver.chrome.driver", rootpath+"/src/test/resources/driver/chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("--start-maximized");
        ops.addArguments("--incognito");
        ops.setExperimentalOption("useAutomationExtension", false);
        ops.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver = new ChromeDriver(ops);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("https://www.spicejet.com/");
    }

    @Test
    public void hovertest(){
        Actions actions = new Actions(driver);
        WebElement addon = driver.findElement(By.xpath("//div[contains(text(),'Add-ons')]"));
        actions.moveToElement(addon).build().perform();
        WebElement click = driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-ubezar'][normalize-space()='SpiceMax']"));
        actions.moveToElement(click).click().perform();
        }

    @Test
    public void doubleclick(){
        Actions actions = new Actions(driver);
        WebElement dclick= driver.findElement(By.xpath("//div[@class='css-76zvg2 r-qsz3a2 r-2t9rge r-adyw6z r-1kfrs79']"));
        actions.moveToElement(dclick).doubleClick().perform();
    }

    @Test
    public void rightclick(){
        //here we perform series of action and rightclick
        Actions actions = new Actions(driver);
        WebElement rclick= driver.findElement(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41 r-1pzd9i8'][normalize-space()='SpiceClub']"));
        actions.moveToElement(rclick).perform();
        WebElement rclick2=driver.findElement(By.xpath("//div[contains(text(),'Our Program')]"));
        actions.contextClick(rclick2).perform();

    }

    @Test
    public void dragdrop(){
        driver.get("https://jqueryui.com/droppable/");
        Actions actions = new Actions(driver);
        //switch to frame first
        WebElement w= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(w);
        actions.dragAndDrop(driver.findElement(By.xpath("//p[normalize-space()='Drag me to my target']")), driver.findElement(By.xpath("//p[normalize-space()='Drop here']"))).perform();

    }
}


