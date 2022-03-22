import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class MonHocTestNgoaiLe {
    MonHoc mh;

    @Before
    public void setUp() throws Exception {
        mh = new MonHoc();
    }

    @After
    public void tearDown() throws Exception {
        mh = null;
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testMaMHisEmpty() {
        exception.expect(IllegalArgumentException.class);
        MonHoc monHoc = new MonHoc("", "JAVA", "NOTE", 12, 12, "20000000");
        monHoc.testIsEmpty();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTenMHisEmpty() {
        MonHoc monHoc = new MonHoc("ducnv", "", "NOTE", 12, 12, "20000000");
        monHoc.testIsEmpty();
    }

    @Test
    public void testThoiLuongisEmpty() {
        try {
            MonHoc monHoc = new MonHoc("ducnv", "JAVA", "NOTE", Integer.parseInt(""), 12, "20000000");
            monHoc.testIsEmpty();
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void testHocPhiisEmpty() {
        try {
            MonHoc monHoc = new MonHoc("ducnv", "JAVA", "NOTE", 12, 12, "");
            monHoc.testIsEmpty();
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testsoHocVIenisEmpty() {
        MonHoc monHoc = new MonHoc("ducnv", "JAVA", "NOTE", 12, Integer.parseInt(""), "20000000");
        monHoc.testIsEmpty();
    }


    @Test
    public void testThoiLuongWithText() {
        try {
            MonHoc monHoc = new MonHoc("ducnv", "JAVA", "NOTE", Integer.parseInt("abcd"), 12, "20000000");
            monHoc.regexTest();
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void testHocPhiWithText() {
        try {
            MonHoc monHoc = new MonHoc("ducnv", "JAVA", "NOTE", 12, 12, "abc");
            monHoc.regexTest();
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void testHocVienWithText() {
        try {
            MonHoc monHoc = new MonHoc("ducnv", "JAVA", "NOTE", 12, Integer.parseInt("abc"), "20000000");
            monHoc.regexTest();

            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGhiChuisEmpty() {
        MonHoc monHoc = new MonHoc("ducnv", "JAVA", "", 12, 32, "20000000");
        monHoc.testIsEmpty();

    }
}