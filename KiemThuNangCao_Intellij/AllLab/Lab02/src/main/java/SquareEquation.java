import model.Roots;

public class SquareEquation {
    private double a, b, c;

    public SquareEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Roots Solution() {
        Roots result = new Roots();
        double d = b * b - 4 * a * c;
        if (a == 0) {
            if (b == 0) {
                throw new ArithmeticException("Solution has no roots");
            } else {
                result.x1 = -c / b;
            }
        }else{
            if (d < 0) {
                throw new ArithmeticException("Solution has no roots");
            } else if (d == 0) {
                result.x1 = (-b) / (2 * a);
            } else {
                result.x1 = (-b - Math.sqrt(d)) / (2 * a);
                result.x2 = (-b + Math.sqrt(d)) / (2 * a);
            }
        }
        return result;
    }
}
