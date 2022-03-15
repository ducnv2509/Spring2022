import model.Roots;

public class SquareEquation {
    private double a, b, c;

    public SquareEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Roots Solution() {
        double d = b * b - 4 * a * c;
        if(d < 0){
            throw  new ArithmeticException("Solution has no roots");
        }
        Roots result = new Roots();
        result.x1 = (-b - Math.sqrt(d) / (2 * a));
        result.x2 = (-b + Math.sqrt(d) / (2 * a));
        return  result;
    }
}
