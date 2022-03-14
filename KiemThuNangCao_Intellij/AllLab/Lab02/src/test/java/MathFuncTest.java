import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathFuncTest {

    MathFunc math;
    @BeforeEach
    void setUp() {
        math = new MathFunc();
    }

    @AfterEach
    void tearDown() {
        math = null;
    }



    @Test
    void getCalls() {

    }

    @Test
    void factorial() {
        assertTrue(math.factorial(0) == 1);
        assertTrue(math.factorial(1) == 1);
        assertTrue(math.factorial(5)==120);
    }
    @Test()
    public void factorialNegative(){
        math.factorial(-1);
    }
    @Disabled
    @Test
    public void todo(){
        assertTrue(math.plus(1,1) == 3);
    }

    @Test
    void plus() {
        assertEquals(0, math.getCalls());
        math.factorial(1);
        assertEquals(1, math.getCalls());
        math.factorial(1);
        assertEquals(2, math.getCalls());
    }
}