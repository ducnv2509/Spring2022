import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class MonHocTestGiaTriBien {

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
    public void testThoiLuongMin1() {
        exception.expect(IllegalArgumentException.class);
        MonHoc monHoc = new MonHoc("ducnv", "JAVA", "NOTE", -1, 12, "20000000");
        monHoc.regexTest();
    }

    @Test
    public void testThoiLuongMin2() {
        exception.expect(IllegalArgumentException.class);
        MonHoc monHoc = new MonHoc("ducnv", "JAVA", "NOTE", 0, 12, "20000000");
        monHoc.regexTest();

    }

    @Test
    public void testThoiLuongMax() {
        try {
            MonHoc monHoc = new MonHoc("ducnv", "JAVA", "NOTE", 91, 12, "20000000");
            monHoc.regexTest();

            fail();
        } catch (IllegalArgumentException e) {

        }
    }


    @Test
    public void testHocPhiMin() {
        try {
            MonHoc monHoc = new MonHoc("ducnv", "JAVA", "NOTE", 12, 12, "-1");
            monHoc.regexTest();

            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void testHocPhiMin2() {
        try {
            MonHoc monHoc = new MonHoc("ducnv", "JAVA", "NOTE", 12, 12, "0");
            monHoc.regexTest();

            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void testHocPhiMax() {
        try {
            MonHoc monHoc = new MonHoc("ducnv", "JAVA", "NOTE", 12, 12, "20000001");
            monHoc.regexTest();

            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testsoHocVIenMin1() {
        MonHoc monHoc = new MonHoc("ducnv", "JAVA", "NOTE", 12, -1, "20000000");
        monHoc.regexTest();

    }

    @Test(expected = IllegalArgumentException.class)
    public void testsoHocVIenMin2() {
        MonHoc monHoc = new MonHoc("ducnv", "JAVA", "NOTE", 12, 0, "20000000");
        monHoc.regexTest();

    }

    @Test(expected = IllegalArgumentException.class)
    public void testsoHocVIenMax() {
        MonHoc monHoc = new MonHoc("ducnv", "JAVA", "NOTE", 12, 41, "20000000");
        monHoc.regexTest();

    }
}