import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class TinhGiaThuaTest {
    TinhGiaThua goi;

    @Before
    public void setUp() throws Exception {
        goi = new TinhGiaThua();
    }

    @After
    public void tearDown() throws Exception {
        goi = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGiaithualasoam() throws Exception {

        goi.Giaithua(-1);
        goi.Giaithua(-22);
        goi.Giaithua(-11);

    }

    // bắt ngoại lệ với trycatch
    @Test
    public void kiemtranhunggiaithuasai() throws Exception {

        try {
            goi.Giaithua(-1);
            goi.Giaithua(22);
            goi.Giaithua(21);
            fail("không bắt được ngoại lệ");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void kiemtranhunggiaithuasaivoighichuloi() throws Exception {
        try {
            goi.Giaithua(-1);
            goi.Giaithua(22);
            goi.Giaithua(21);
            fail("không bắt được ngoại lệ");
        } catch (IllegalArgumentException e) {
            assertEquals("Số nhập vào không được âm và trong khoảng 0. .20 ",e.getMessage());
        }

    }

    // bắt ngoại lệ theo quy tắc Rule
    @Rule
    public ExpectedException ngoaile = ExpectedException.none();

    @Test
    public void kiemtrangoailevoiquytac() throws Exception {
        ngoaile.expect(IllegalArgumentException.class);
        goi.Giaithua(-1);

        goi.Giaithua(22);

        goi.Giaithua(21);

    }
}