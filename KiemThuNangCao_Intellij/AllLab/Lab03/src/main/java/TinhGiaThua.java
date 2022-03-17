public class TinhGiaThua {
    int sonhap;
    public int getSoNhap() {
        return sonhap;
    }

    public long Giaithua(int sotinh) {
        if (sotinh < 0 || sotinh >= 21)
            throw new IllegalArgumentException("Số nhập vào không được âm và trong khoảng 0. .20 ");
        if (sotinh == 0)
            return 1;
        long ketquagiaithua = 1;

        for (int i = 1; i <= sotinh; i++) {
            ketquagiaithua = ketquagiaithua * i;
        }
        return ketquagiaithua;
    }

    public int tong(int a, int b) {
        return a + b;
    }
}
