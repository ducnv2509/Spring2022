import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class KyThuatTestGiaTriBien {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver.get("https://live.techpanda.org/");
    }

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test(dataProvider = "dataTestSuccess")
    public void testPassQuantity(String quantity) {
        driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button/span/span")).click();
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/input")).sendKeys(quantity);
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/button/span/span")).click();
        Assertions.assertEquals(Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/div/a/span[3]")).getText()), Integer.parseInt(quantity));
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[6]/a")).click();
    }

    @Test(dataProvider = "dataFailed")
    public void testPassQuantityFailed(String quantity) {
        driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button/span/span")).click();
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/input")).sendKeys(quantity);
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/button/span/span")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[2]/p")).getText().trim(), "* The maximum quantity allowed for purchase is 500.");
        driver.findElement(By.xpath("//*[@id=\"empty_cart_button\"]/span/span")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div[1]/h1")).getText().trim(), "SHOPPING CART IS EMPTY");
    }

    @DataProvider(name = "dataTestSuccess")
    public Object[][] dataSuccess() {
        return new Object[][]{
                {"1"},
                {"499"},
                {"500"}
        };
    }

    @DataProvider(name = "dataFailed")
    public Object[][] dataFailed() {
        return new Object[][]{
                {"1000"},
                {"501"}
        };
    }

//    @AfterMethod
//    public void tearDown() {
//        driver = null;
//    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
