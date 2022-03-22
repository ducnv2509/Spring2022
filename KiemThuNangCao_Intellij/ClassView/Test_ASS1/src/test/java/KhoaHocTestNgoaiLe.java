import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class KhoaHocTestNgoaiLe {

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
    public void testMaKHisEmpty() {
        exception.expect(IllegalArgumentException.class);
        new KhoaHoc("", "JAVA", "NOTE", 12, 12, "25000000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTenKHisEmpty() {
        new KhoaHoc("ducnv", "", "NOTE", 12, 12, "25000000");
    }

    @Test
    public void testThoiLuongisEmpty() {
        try {
            new KhoaHoc("ducnv", "JAVA", "NOTE", Integer.parseInt(""), 12, "25000000");
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void testHocPhiisEmpty() {
        try {
            new KhoaHoc("ducnv", "JAVA", "NOTE", 12, 12, "");
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testsoHocVIenisEmpty() {
        new KhoaHoc("ducnv", "JAVA", "NOTE", 12, Integer.parseInt(""), "25000000");
    }


    @Test
    public void testThoiLuongWithText() {
        try {
            new KhoaHoc("ducnv", "JAVA", "NOTE", Integer.parseInt("abcd"), 12, "25000000");
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void testHocPhiWithText() {
        try {
            new KhoaHoc("ducnv", "JAVA", "NOTE", 12, 12, "abc");
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void testHocVienWithText() {
        try {
            new KhoaHoc("ducnv", "JAVA", "NOTE", 12, Integer.parseInt("abc"), "25000000");
            fail();
        } catch (IllegalArgumentException e) {

        }
    }
}