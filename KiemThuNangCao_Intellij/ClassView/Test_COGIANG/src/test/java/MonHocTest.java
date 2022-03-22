import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonHocTest {

    MonHoc mh;

    @Before
    public void setUp() throws Exception {
        mh = new MonHoc();
    }

    @After
    public void tearDown() throws Exception {
        mh = null;
    }

    @Test
    public void getMaMH() {
        assertNull(mh.getMaMH());
    }

    @Test
    public void setMaMH() {
        mh.setMaMH("ducnv");
        assertEquals("ducnv", mh.getMaMH());
    }

    @Test
    public void getTenMH() {
        assertNull(mh.getTenMH());
    }


    @Test
    public void setTenMH() {
        mh.setTenMH("JAVA");
        assertEquals("JAVA", mh.getTenMH());
    }

    @Test
    public void getGhiChu() {
        assertNull(mh.getGhiChu());
    }

    @Test
    public void setGhiChu() {
        mh.setGhiChu("NOTE");
        assertEquals("NOTE", mh.getGhiChu());
    }

    @Test
    public void getHocPhi() {
        assertNull(mh.getHocPhi());

    }

    @Test
    public void setHocPhi() {
        mh.setHocPhi("20000000");
        assertEquals("20000000", mh.getHocPhi());
        mh.setHocPhi("19999999");
        assertEquals("19999999", mh.getHocPhi());
    }

    @Test
    public void getThoiLuong() {
        assertEquals(0, mh.getThoiLuong());
    }

    @Test
    public void setThoiLuong() {
        mh.setThoiLuong(0);
        assertEquals(0, mh.getThoiLuong());
        mh.setThoiLuong(1);
        assertEquals(1, mh.getThoiLuong());
        mh.setThoiLuong(89);
        assertEquals(89, mh.getThoiLuong());
    }

    @Test
    public void getSoLuongHocVien() {
        assertEquals(0, mh.getSoLuongHocVien());
    }

    @Test
    public void setSoLuongHocVien() {
        mh.setSoLuongHocVien(0);
        assertEquals(0, mh.getSoLuongHocVien());
        mh.setSoLuongHocVien(1);
        assertEquals(1, mh.getSoLuongHocVien());
        mh.setSoLuongHocVien(39);
        assertEquals(39, mh.getSoLuongHocVien());
    }
}