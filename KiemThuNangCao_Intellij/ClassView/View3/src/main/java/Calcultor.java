public class Calcultor {
    public int Tong(int a, int b) {
        return a + b;
    }

    public int Tru(int a, int b) {
        return a - b;
    }

    public int Nhan(int a, int b) {

        return a * b;
    }

    public int Chia(int a, int b) {
        if (a == 0) {
            throw new ArithmeticException("Vo Nghiem");
        }
        return a / b;
    }

    public int BinhPhuong(int a, int b) {
        return (int) Math.pow(a, b);
    }
}
