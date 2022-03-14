import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MathFuncTest2 {
    MathFunc math;

    @Before
    public void setUp() throws Exception {
        math = new MathFunc();

    }

    @After
    public void tearDown() throws Exception {
        math = null;
    }

    @Test()
    public void getCalls() {
    }

    @Test
    public void factorial() {
        assertTrue(math.factorial(0) == 1);
        assertTrue(math.factorial(1) == 1);
        assertTrue(math.factorial(5) == 120);
    }

    @Test(expected = IllegalArgumentException.class)
    public void factorialNegative() {
        math.factorial(-1);
    }

    @Ignore
    @org.junit.jupiter.api.Test
    public void todo(){
        assertTrue(math.plus(1,1) == 3);
    }
    @Test
    public void plus() {
        assertEquals(0, math.getCalls());
        math.factorial(1);
        assertEquals(1, math.getCalls());
        math.factorial(1);
        assertEquals(2, math.getCalls());
    }

}