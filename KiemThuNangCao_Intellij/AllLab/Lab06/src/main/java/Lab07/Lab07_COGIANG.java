package Lab07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab07_COGIANG {
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://live.techpanda.org/");
    }

    @Test(priority = 0)
    public void checkTitle() {
        Assert.assertEquals(driver.getTitle(), "Home page");
    }

    @Test(priority = 1)
    public void checkTitleContent() {
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[1]/div/div/h2")).getText().trim(), "THIS IS DEMO SITE FOR");
    }

    @Test(priority = 2)
    public void checkTitleMobile() {
        driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a")).click();
        driver.findElement(By.tagName("select")).click();
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select/option[2]")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/mobile.html?dir=asc&order=name");
    }

    @Test(priority = 3)
    public void checkPrice() {
        driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a")).click();
        String priceHome = driver.findElement(By.xpath("//*[@id=\"product-price-1\"]/span")).getText();
        driver.findElement(By.xpath("//*[@id=\"product-collection-image-1\"]")).click();
        String priceDetails = driver.findElement(By.xpath("//*[@id=\"product-price-1\"]/span")).getText();
        Assert.assertEquals(priceHome, priceDetails);
    }


    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
