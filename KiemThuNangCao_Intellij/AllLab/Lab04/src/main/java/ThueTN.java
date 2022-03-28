public class ThueTN {
    public double thue(double thuNhap) {
        long result = 0;
        if (thuNhap <= 5000000) {
            result = (long) (thuNhap * 0.05);
        } else if (thuNhap <= 10000000) {
            result = (long) (thuNhap * 0.1 + 250000);
        } else if (thuNhap <= 18000000) {
            result = (long) (thuNhap * 0.15 + 750000);
        } else if (thuNhap <= 32000000) {
            result = (long) (thuNhap * 0.2 + 1950000);
        } else if (thuNhap <= 52000000) {
            result = (long) (thuNhap * 0.25 + 4750000);
        } else if (thuNhap <= 80000000) {
            result = (long) (thuNhap * 0.3 + 9750000);
        } else {
            result = (long) (thuNhap * 0.35 + 18150000);
        }
        return result;
    }


}
