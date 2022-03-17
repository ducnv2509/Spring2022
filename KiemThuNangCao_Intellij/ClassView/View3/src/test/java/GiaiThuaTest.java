import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GiaiThuaTest {

    GiaiThua gt;
    @Before
    public void setUp() throws Exception {
        gt = new GiaiThua();
    }

    @After
    public void tearDown() throws Exception {
        gt = null;
    }

    @Test(expected =  IllegalArgumentException.class)
    public void testgiaithualasoam() throws Exception{
        gt.factorial(-1);
    }

    @Test
    public void kiemtragiaithuabangtrycatch() throws Exception{
        try {
            gt.factorial(-4);
            fail("ERROR");
        }catch (IllegalArgumentException e){
            assertEquals("fdfd", e.getMessage());
        }
    }

    @Test
    public void getCalls() {
    }

    @Test
    public void factorial() {
    }

    @Test
    public void plus() {
    }
}