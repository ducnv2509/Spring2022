import model.Roots;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquareEquationTest2 {
    private SquareEquation se;
    private SquareEquation se2;

    @Before
    public void setUp() throws Exception {
        se =  new SquareEquation(0, 6, -12);
        se2 =  new SquareEquation(2, 4, 2);
    }

    @After
    public void tearDown() throws Exception {
        se =null;
        se2 =null;
    }

    @Test
    public void solution() {
        Roots rt = se.Solution();
        assertEquals(rt.x1, 2, 0);
    }

    @Test
    public void solution2() {
        Roots rt = se2.Solution();
        assertEquals(rt.x1, -1, 0);
    }
    @Test
    public void solution3() {
        Roots rt = se.Solution();
        assertEquals(rt.x1, -1.5, 0);
    }

    @Test
    public void solution4() {
        Roots rt = se2.Solution();
        assertEquals(rt.x1, -9, 0);
    }

}
