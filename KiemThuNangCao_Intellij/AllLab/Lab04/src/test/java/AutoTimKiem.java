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

public class AutoTimKiem {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @Test(groups = "fpt")
    public void timKiemTT(){
        WebDriverManager.chromedriver().setup();
        WebDriver goi = new ChromeDriver();
        String url = "http://google.com";
        goi.manage().window().maximize();
        goi.get(url);
        goi.findElement(By.name("q")).sendKeys("Cao đẳng FPT");
        WebElement ten  = goi.findElements(By.name("btnK")).get(1);
        Actions chay = new Actions(goi).click();
        chay.build().perform();
        goi.close();
    }

    @Test(groups = "fpt")
    public void timKiemTT2(){
        WebDriverManager.chromedriver().setup();
        WebDriver goi = new ChromeDriver();
        String url = "http://google.com";
        goi.manage().window().maximize();
        goi.get(url);
        goi.findElement(By.name("q")).sendKeys("Cao đẳng Btec");
        WebElement ten  = goi.findElements(By.name("btnK")).get(1);
        Actions chay = new Actions(goi).click();
        chay.build().perform();
        goi.close();
    }

    @Test(groups = "fpt")
    public void timKiemTT3(){
        WebDriverManager.chromedriver().setup();
        WebDriver goi = new ChromeDriver();
        String url = "http://google.com";
        goi.manage().window().maximize();
        goi.get(url);
        goi.findElement(By.name("q")).sendKeys("Dai Hoc FPT");
        WebElement ten  = goi.findElements(By.name("btnK")).get(1);
        Actions chay = new Actions(goi).click();
        chay.build().perform();
        goi.close();
    }
}