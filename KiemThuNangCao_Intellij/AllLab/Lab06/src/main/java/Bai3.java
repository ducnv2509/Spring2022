import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Bai3 {
    @Parameters({"BrowserName"})
    @Test
    public void openBrowser(String name){
        System.out.println("browser passed at: " + name);
    }

    @Parameters({"Username", "Password"})
    @Test
    public void FillLoginForm(String username, String password){
        System.out.println("Parameter for username passed at: " + username);
        System.out.println("Parameter for password passed at: " + password);
    }
}
