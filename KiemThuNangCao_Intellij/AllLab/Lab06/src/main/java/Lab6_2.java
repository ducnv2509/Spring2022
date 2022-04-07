import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lab6_2 {
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.demo.guru99.com/V4/");
    }

    @Test(dataProvider = "dataTestFailed")
    public void f(String username, String password) {
        driver.findElement(By.name("uid")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("btnLogin")).click();
        String alert = driver.switchTo().alert().getText();
        Assert.assertEquals(alert, "User or Password is not valid");
        driver.switchTo().alert().accept();
    }

    @DataProvider(name = "dataTestFailed")
    public Object[][] db() {
        return new Object[][]{
                {"mngr394913", "12345"},
                {"mngr394912", "revegAz"},
                {"mngr394912", "revegsAz"}
        };
    }
    @Test(dataProvider = "dataTestSuccess")
    public void fa(String username, String password) {
        driver.findElement(By.name("uid")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("btnLogin")).click();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.demo.guru99.com/V4/manager/Managerhomepage.php");
    }


    @DataProvider(name = "dataTestSuccess")
    public Object[][] dataSuccess() {
        return new Object[][]{
                {"mngr394913", "revegAz"}
        };
    }



    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
