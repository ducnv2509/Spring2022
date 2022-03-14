import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareEquationTest {

    private SquareEquation se;
    @Before
    public void setUp() throws Exception {
        se =  new SquareEquation(2, 1, -3);
    }

    @After
    public void tearDown() throws Exception {
        se =null;
    }

    @Test
    public void solution() {
        Roots rt = se.Solution();
        assertEquals(rt.x1, -1.5, 5);
        assertEquals(rt.x2, 1.0, 5);
    }

    @Test
    public void solution2() {
        Roots rt = se.Solution();
        assertEquals(rt.x1, -1.5, 5);
        assertEquals(rt.x2, 0.5, 5);
    }
    @Test
    public void solution3() {
        Roots rt = se.Solution();
        assertEquals(rt.x1, 2, 5);
        assertEquals(rt.x2, 7, 10);
    }


}