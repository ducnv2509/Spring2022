import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class test {

    WebDriver driver;

    @Test(dataProvider = "dulieu")
    public void f(String tenweb, String tieude) {
        driver.get(tenweb);
        Assert.assertEquals(driver.getTitle(), tieude);
    }

    @DataProvider(name = "dulieu")
    public Object[][] db() {
        return new Object[][]{
                {"https://ap.poly.edu.vn/", "Cao đẳng FPT Polytechnic"},
                {"https://lms.poly.edu.vn/", "Learning Management System | Hệ thống quản trị học tập | FPT Polytechnic Việt Nam"},
                {"https://cms.poly.edu.vn/", "Dashboard | FPT Polytechnic | Course Management System"}
        };
    }

    @BeforeTest
    public void beforTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void affterTest() {
        driver.close();
    }
}
