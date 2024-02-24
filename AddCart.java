import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.concurrent.TimeUnit;
public class AddCart {

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
    }

    @Test
    public void test1() {
        driver.navigate().to("https://www.daraz.com.np/");
        String title = driver.getTitle();
        System.out.println("This is the title of website " + title);
        WebElement SearchBox= driver.findElement(By.id("q"));
        SearchBox.sendKeys("iphone 15 pro");
        SearchBox.submit();
        driver.findElement(By.cssSelector("body > div:nth-child(15) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1) > img:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".next-icon.next-icon-add.next-icon-medium")).click();
        WebElement addCart = driver.findElement(By.xpath("//button[contains(@class, 'add-to-cart-buy-now-btn') and contains(@class, 'pdp-button') and contains(@class, 'pdp-button_type_text') and contains(@class, 'pdp-button_theme_orange') and contains(@class, 'pdp-button_size_xl')]"));
        addCart.click();

    }
}

