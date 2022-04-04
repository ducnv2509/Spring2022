import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab6_1 {
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Check login Guru99");
        driver.get("https://www.demo.guru99.com/V4/");
        driver.findElement(By.name("uid")).sendKeys("mngr394913");
        driver.findElement(By.name("password")).sendKeys("revegAz");
        driver.findElement(By.name("btnLogin")).click();
    }

    @Test
    public void checkLoginSuccessTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Guru99 Bank Home Page");
        System.out.println("Is Title: " + title);
    }

    @Test
    public void checkLoginSuccessContent() {
        String welcome = driver.findElement(By.className("heading3")).getText();
        Assertions.assertEquals(welcome, "Welcome To Manager's Page of Guru99 Bank");
        System.out.println("IS: " + welcome);
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
