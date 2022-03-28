import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class KiemtraTieuDeTest {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test
    public void kiemTraTieuDeAP() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://ap.poly.edu.vn/");
        assertEquals(driver.getTitle(), "Cao đẳng FPT Polytechnic");
        driver.close();
    }

    @Test
    public void kiemTraCMS() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://cms.poly.edu.vn/");
        assertEquals(driver.getTitle(), "| FPT Polytechnic | Course Management System");
        driver.close();
    }

    @Test
    public void kiemTraLMS() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://lms.poly.edu.vn/");
        assertEquals(driver.getTitle(), "Learning Management System | Hệ thống quản trị học tập | FPT Polytechnic Việt Nam");
        driver.close();
    }
}