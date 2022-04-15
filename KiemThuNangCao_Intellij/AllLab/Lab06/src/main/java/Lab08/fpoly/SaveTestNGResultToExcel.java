package Lab08.fpoly;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class SaveTestNGResultToExcel {
    public WebDriver driver;
    public UIMap uiMap;
    public UIMap dataFile;
    public String workingDir;

    HSSFWorkbook workbook;
    HSSFSheet sheet;
    Map<String, Object[]> TestNGResults;
    public static String drive = "D:\\selenium";

    @Test(description = "Open the testNG demo website for Login Test", priority = 1)
    public void LauchWebsite() throws Exception {
        try {
            driver.get("https://www.phptravels.net/login");
            driver.manage().window().maximize();
            TestNGResults.put("2", new Object[]{1d, "Navigate to demo websites", "Site gets opened", "Pass"});
        } catch (Exception e) {
            TestNGResults.put("2", new Object[]{1d, "Navigate to demo website", "Site gets opened", "Fail"});
            Assert.assertTrue(false);
        }
    }

    @Test(description = "Fill the login details", priority = 2)
    public void FillLoginDetails() throws Exception {
        try {
            WebElement username = driver.findElement(uiMap.getLocator("Username_filed"));
            username.sendKeys(dataFile.getData("username"));

            WebElement password = driver.findElement(uiMap.getLocator("Password_field"));
            password.sendKeys(dataFile.getData("password"));

            Thread.sleep(1000);

            TestNGResults.put("3", new Object[]{2d, "Fill login form data (Username/Password)", "Login details gets filled", "Pass"});
        } catch (Exception e) {
            TestNGResults.put("3", new Object[]{
                    2d, "Fill login form data (Username/Password)", "Login form get filled", "Fail"
            });
            Assert.assertTrue(false);
        }
    }

    @Test(description = "Perform Login", priority = 3)
    public void doLogin() throws Exception {
        try {
            WebElement login = driver.findElement(uiMap.getLocator("Login_button"));
            login.click();
            Thread.sleep(1000);
            WebElement onlineuser = driver.findElement(uiMap.getLocator("online_user"));
            TestNGResults.put("4", new Object[]{
                    "Click Login and verify welcome message", "Login success", "Pass"
            });
        } catch (Exception e) {
            TestNGResults.put("4", new Object[]{
                    "Click Login and verify welcome message", "Login success", "Fail"
            });
            Assert.assertTrue(false);
        }
    }

    @BeforeClass(alwaysRun = true)
    public void suiteSetup(){
        workbook = new HSSFWorkbook();
        sheet = workbook.createSheet("TestNG Result Summary");
        TestNGResults = new LinkedHashMap<String, Object[]>();

        TestNGResults.put("1", new Object[]{
                "Test step no. ", "Action","Expected output", "Actual output"
        });
        try {
            FileOutputStream out = new FileOutputStream(new File("SaveTestNGResultToExcel.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("OK");
        } catch (IOException e){
            e.printStackTrace();
        }
        driver.close();
        driver.quit();
    }
}
