public class KhoaHoc {

    private String maKH, tenKH, ghiChu, hocPhi;
    private int thoiLuongKH, soHocVien;

    public KhoaHoc() {
    }

    public KhoaHoc(String maKH, String tenKH, String ghiChu, int thoiLuongKH, int soHocVien, String hocPhi) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.thoiLuongKH = thoiLuongKH;
        this.soHocVien = soHocVien;
        this.hocPhi = hocPhi;
        this.ghiChu = ghiChu;

        if (maKH.isEmpty()) {
            throw new IllegalArgumentException("Mã khoá học không hợp lệ");
        } else if (tenKH.isEmpty()) {
            throw new IllegalArgumentException("Tên khoá học không hợp lệ");
        } else if (String.valueOf(thoiLuongKH).isEmpty()) {
            throw new IllegalArgumentException("Thời lượng khoá học không hợp lệ");
        } else if (hocPhi.isEmpty()) {
            throw new IllegalArgumentException("Học phí khoá học không hợp lệ");
        } else if (String.valueOf(soHocVien).isEmpty()) {
            throw new IllegalArgumentException("Số học viên không hợp lệ");
        } else if (thoiLuongKH > 120 || thoiLuongKH <= 0) {
            throw new IllegalArgumentException("Thời lượng khoá học không hợp lệ");
        } else if (!String.valueOf(thoiLuongKH).matches("^\\d+$")) {
            throw new IllegalArgumentException("Thời lượng khoá học không hợp lệ");
        } else if (!hocPhi.matches("^\\d+$")) {
            throw new IllegalArgumentException("Học phí khoá học không hợp lệ");
        } else if (Double.parseDouble(hocPhi) > 50000000 || Double.parseDouble(hocPhi) < 1000) {
            throw new IllegalArgumentException("Học phí khoá học không hợp lệ");
        } else if (!String.valueOf(soHocVien).matches("^\\d+$")) {
            throw new IllegalArgumentException("Số học viên không hợp lệ");
        } else if (soHocVien > 25 || soHocVien <= 0) {
            throw new IllegalArgumentException("Số học viên không hợp lệ");
        }

    }

//    public void Validate() {
//        if (thoiLuongKH > 120 || thoiLuongKH <= 0) {
//            throw new IllegalArgumentException("Thời lượng khoá học không hợp lệ");
//        } else if (!String.valueOf(thoiLuongKH).matches("[0-9]")) {
//            throw new IllegalArgumentException("Thời lượng khoá học không hợp lệ");
//        } else if (!hocPhi.matches("[0-9]")) {
//            throw new IllegalArgumentException("Học phí khoá học không hợp lệ");
//        } else if (hocPhi.length() > 8 || hocPhi.length() < 4) {
//            throw new IllegalArgumentException("Học phí khoá học không hợp lệ");
//        } else if (Double.parseDouble(hocPhi) > 25000000 || Double.parseDouble(hocPhi) < 1000) {
//            throw new IllegalArgumentException("Học phí khoá học không hợp lệ");
//        } else if (!String.valueOf(soHocVien).matches("[0-9]")) {
//            throw new IllegalArgumentException("Số học viên không hợp lệ");
//        } else if (soHocVien > 25 || soHocVien <= 0) {
//            throw new IllegalArgumentException("Số học viên không hợp lệ");
//        }
//    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getThoiLuongKH() {
        return thoiLuongKH;
    }

    public void setThoiLuongKH(int thoiLuongKH) {
        this.thoiLuongKH = thoiLuongKH;
    }

    public int getSoHocVien() {
        return soHocVien;
    }

    public void setSoHocVien(int soHocVien) {
        this.soHocVien = soHocVien;
    }

    public String getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(String hocPhi) {
        this.hocPhi = hocPhi;
    }
}
