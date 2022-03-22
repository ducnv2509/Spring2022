public class MonHoc {
    private String maMH, tenMH, ghiChu, hocPhi;
    private int thoiLuong, soLuongHocVien;

    public MonHoc() {

    }

    public MonHoc(String maMH, String tenMH, String ghiChu, int thoiLuong, int soLuongHocVien, String hocPhi) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.hocPhi = hocPhi;
        this.thoiLuong = thoiLuong;
        this.soLuongHocVien = soLuongHocVien;
        this.ghiChu = ghiChu;

//        if (maMH.isEmpty()) {
//            throw new IllegalArgumentException("Mã môn học không hợp lệ");
//        } else

//        if (tenMH.isEmpty()) {
//            throw new IllegalArgumentException("Tên môn học không hợp lệ");
//        } else if (String.valueOf(thoiLuong).isEmpty()) {
//            throw new IllegalArgumentException("Thời lượng môn học không hợp lệ");
//        } else if (hocPhi.isEmpty()) {
//            throw new IllegalArgumentException("Học phí môn học không hợp lệ");
//        } else if (String.valueOf(soLuongHocVien).isEmpty()) {
//            throw new IllegalArgumentException("Số học viên viên không hợp lệ");
//        } else if (thoiLuong > 90 || thoiLuong <= 0) {
//            throw new IllegalArgumentException("Thời lượng môn học không hợp lệ");
//        } else if (!String.valueOf(thoiLuong).matches("^\\d+$")) {
//            throw new IllegalArgumentException("Thời lượng môn học không hợp lệ");
//        } else if (!hocPhi.matches("^\\d+$")) {
//            throw new IllegalArgumentException("Học phí môn học không hợp lệ");
//        } else if (Double.parseDouble(hocPhi) > 20000000 || Double.parseDouble(hocPhi) <= 0) {
//            throw new IllegalArgumentException("Học phí môn học không hợp lệ");
//        } else if (!String.valueOf(soLuongHocVien).matches("^\\d+$")) {
//            throw new IllegalArgumentException("Số học viên không hợp lệ");
//        } else if (soLuongHocVien > 40 || soLuongHocVien <= 0) {
//            throw new IllegalArgumentException("Số học viên không hợp lệ");
//        } else if (ghiChu.isEmpty()) {
//            throw new IllegalArgumentException("Ghi chú không hợp lệ");
//        }
    }

    public void testIsEmpty() {
        if (maMH.isEmpty()) {
            throw new IllegalArgumentException("Mã môn học không hợp lệ");
        } else if (tenMH.isEmpty()) {
            throw new IllegalArgumentException("Tên môn học không hợp lệ");
        } else if (String.valueOf(thoiLuong).isEmpty()) {
            throw new IllegalArgumentException("Thời lượng môn học không hợp lệ");
        } else if (hocPhi.isEmpty()) {
            throw new IllegalArgumentException("Học phí môn học không hợp lệ");
        } else if (String.valueOf(soLuongHocVien).isEmpty()) {
            throw new IllegalArgumentException("Số học viên viên không hợp lệ");
        } else if (ghiChu.isEmpty()) {
            throw new IllegalArgumentException("Ghi chú không hợp lệ");
        }
    }

    public void regexTest() {
        if (thoiLuong > 90 || thoiLuong <= 0) {
            throw new IllegalArgumentException("Thời lượng môn học không hợp lệ");
        } else if (!String.valueOf(thoiLuong).matches("^\\d+$")) {
            throw new IllegalArgumentException("Thời lượng môn học không hợp lệ");
        } else if (!hocPhi.matches("^\\d+$")) {
            throw new IllegalArgumentException("Học phí môn học không hợp lệ");
        } else if (Double.parseDouble(hocPhi) > 20000000 || Double.parseDouble(hocPhi) <= 0) {
            throw new IllegalArgumentException("Học phí môn học không hợp lệ");
        } else if (!String.valueOf(soLuongHocVien).matches("^\\d+$")) {
            throw new IllegalArgumentException("Số học viên không hợp lệ");
        } else if (soLuongHocVien > 40 || soLuongHocVien <= 0) {
            throw new IllegalArgumentException("Số học viên không hợp lệ");
        }
    }

    public String getMaMH() {

        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;

    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(String hocPhi) {
        this.hocPhi = hocPhi;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public int getSoLuongHocVien() {
        return soLuongHocVien;
    }

    public void setSoLuongHocVien(int soLuongHocVien) {
        this.soLuongHocVien = soLuongHocVien;
    }
}
