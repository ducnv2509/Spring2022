package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Register {

    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://live.techpanda.org/");
    }

    @Test(dataProvider = "pass")
    public void login(String username, String password) {
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[6]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();
        String welcome = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div/div[1]/h1")).getText();
        Assert.assertEquals(welcome, "MY DASHBOARD");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[5]/a")).click();
    }

    @Test
    public void testTitle(){
        Assert.assertEquals(driver.getTitle(), "Home page");
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/");
    }

    @DataProvider(name = "pass")
    public Object[][] dataSuccess() {
        return new Object[][]{
                {"ducit2509@gmail.com", "nguyenvanduc"},
                {"duc1@gmail.com", "ducnv2509"},
                {"duc2@gmail.com", "ducnv2509"}
        };
    }


    @AfterTest
    public void afterTest() {
        driver.close();
    }

}
