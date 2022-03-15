import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class RunCalculator {
    public static void main(String[] args) {
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(TestSuiteCalculator.class);
        System.out.println("run test: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }
}
