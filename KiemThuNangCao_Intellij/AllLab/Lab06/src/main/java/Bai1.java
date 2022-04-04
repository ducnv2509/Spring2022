import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Bai1 {

    WebDriver driver;

    @BeforeTest
    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testTitleAP() {
        driver.get("https://ap.poly.edu.vn/");
        Assert.assertEquals(driver.getTitle(), "Cao đẳng FPT Polytechnic");
    }

    @Test
    public void testTitleLMS() {
        driver.get("https://lms.poly.edu.vn/");
        Assert.assertEquals(driver.getTitle(), "Learning Management System | Hệ thống quản trị học tập | FPT Polytechnic Việt Nam");
    }

    @Test
    public void testTitleCMS() {
        driver.get("https://cms.poly.edu.vn/");
        Assert.assertEquals(driver.getTitle(), "| FPT Polytechnic | Course Management System");
    }


    @AfterTest
    public void terminateBrowser() {
        driver.close();
    }

}
