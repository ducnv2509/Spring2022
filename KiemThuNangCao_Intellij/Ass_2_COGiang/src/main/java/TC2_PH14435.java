import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class TC2_PH14435 {
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://live.techpanda.org/");
        driver.manage().window().maximize();
    }


    @Test
    public void TestSOSANG() {
        driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[3]/div[1]/div[2]/div/button")).click();
        String mainWindows = driver.getWindowHandle(); // 1
        System.out.println(mainWindows);
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            System.out.println(window);
            if (!mainWindows.equals(window)) {
                this.driver.close();
                driver.switchTo().window(window);
                Assert.assertEquals(driver.getTitle(), "Products Comparison List - Magento Commerce");
            }

        }
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
