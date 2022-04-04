import org.testng.annotations.*;

public class Bai2 {
    @BeforeTest
    public void beforeTest() {
        System.out.println("Test Class: beforeTest");
    }

    @Test
    public void unitLever1() {
        System.out.println("Test Class: Unit lv1 testing");
    }

    @Test
    public void unitLever2() {
        System.out.println("Test Class: Unit lv2 testing");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Test Class: Before Method");
    }

    @BeforeMethod
    public static void staticBeforeMethod() {
        System.out.println("Test Class: Static Before Method");
    }

    @Parameters({"param"})
    @BeforeMethod
    public void beforeMethodWithParam(String p) {
        System.out.println("Test Class: before method with param " + p);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Test Class: after method");
    }

    @BeforeClass
    public void afterClass() {
        System.out.println("Test Class: after Class");

    }

    @AfterTest
    public void afterTest() {
        System.out.println("Test Class: after test");
    }
}
