import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestLoginCMS {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }



    @Test
    public void testSearch() {
        WebDriverManager.chromedriver().setup();
        WebDriver call = new ChromeDriver();
        String url = "https://github.com/login";
        call.get(url);
        call.findElement(By.id("login_field")).sendKeys("ducnv2509");
        call.findElement(By.id("password")).sendKeys("ducit2509");
        WebElement name = call.findElement(By.name("commit"));
        Actions run = new Actions(call).click(name);
        run.build().perform();
        call.close();
    }
}