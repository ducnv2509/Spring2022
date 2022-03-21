import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class KhoaHocTestGiaTriBien {

    KhoaHoc kh;

    @Before
    public void setUp() throws Exception {
        kh = new KhoaHoc();
    }

    @After
    public void tearDown() throws Exception {
        kh = null;
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testThoiLuongMin1() {
        exception.expect(IllegalArgumentException.class);
        new KhoaHoc("ducnv", "JAVA", "NOTE", -1, 12, "25000000");
    }

    @Test
    public void testThoiLuongMin2() {
        exception.expect(IllegalArgumentException.class);
        new KhoaHoc("ducnv", "JAVA", "NOTE", 0, 12, "25000000");
    }

    @Test
    public void testThoiLuongMax() {
        try {
            new KhoaHoc("ducnv", "JAVA", "NOTE", 121, 12, "25000000");
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void testHocPhiMin() {
        try {
            new KhoaHoc("ducnv", "JAVA", "NOTE", 12, 12, "999");
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void testHocPhiMax() {
        try {
            new KhoaHoc("ducnv", "JAVA", "NOTE", 12, 12, "25000001");
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testsoHocVIenMin1() {
        new KhoaHoc("ducnv", "JAVA", "NOTE", 12, -1, "25000000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testsoHocVIenMin2() {
        new KhoaHoc("ducnv", "JAVA", "NOTE", 12, 0, "25000000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testsoHocVIenMax() {
        new KhoaHoc("ducnv", "JAVA", "NOTE", 12, 26, "25000000");
    }
}