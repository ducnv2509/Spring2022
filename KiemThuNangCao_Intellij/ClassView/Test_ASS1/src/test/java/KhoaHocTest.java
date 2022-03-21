import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class KhoaHocTest {

    KhoaHoc kh;

    @Before
    public void setUp() throws Exception {
        kh = new KhoaHoc();
    }

    @After
    public void tearDown() throws Exception {
        kh = null;
    }

    @Test
    public void getMaKH() {
        assertNull(kh.getMaKH());
    }

    @Test
    public void setMaKH() {
        kh.setMaKH("ducnv");
        assertEquals("ducnv", kh.getMaKH());
    }

    @Test
    public void getTenKH() {
        assertNull(kh.getTenKH());
    }

    @Test
    public void setTenKH() {
        kh.setTenKH("JAVA");
        assertEquals("JAVA", kh.getTenKH());
    }

    @Test
    public void getGhiChu() {
        assertNull(kh.getGhiChu());
    }

    @Test
    public void setGhiChu() {
        kh.setGhiChu("NOTE");
        assertEquals("NOTE", kh.getGhiChu());
    }

    @Test
    public void getThoiLuongKH() {
        assertEquals(0, kh.getThoiLuongKH());
    }

    @Test
    public void setThoiLuongKH() {
        kh.setThoiLuongKH(119);
        assertEquals(119, kh.getThoiLuongKH());
        kh.setThoiLuongKH(120);
        assertEquals(120, kh.getThoiLuongKH());
    }

    @Test
    public void getSoHocVien() {
        assertEquals(0, kh.getSoHocVien());
    }

    @Test
    public void setSoHocVien() {
        kh.setSoHocVien(24);
        assertEquals(24, kh.getSoHocVien());
        kh.setSoHocVien(25);
        assertEquals(25, kh.getSoHocVien());

    }

    @Test
    public void getHocPhi() {
        assertNull(kh.getHocPhi());
    }

    @Test
    public void setHocPhi() {
        kh.setHocPhi("24999999");
        assertEquals("24999999", kh.getHocPhi());
        kh.setHocPhi("25000000");
        assertEquals("25000000", kh.getHocPhi());
    }
}