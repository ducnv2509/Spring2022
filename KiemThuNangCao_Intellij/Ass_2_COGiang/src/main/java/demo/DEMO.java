package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DEMO {

    WebDriver driver;


    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/ecommerce_Java4_war/HomePage");
    }


    @Test
    public void t1() {
        String textHomePage = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div[2]/a")).getText();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div[2]/a")).click();
        String textDel = driver.findElement(By.xpath("/html/body/section[1]/div/div/div[2]/div/div/h1")).getText();
        Assert.assertEquals(textHomePage, textDel);
    }


    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
