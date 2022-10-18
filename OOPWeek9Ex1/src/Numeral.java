public class Numeral extends Expression {
    private double value;

    Numeral(double value) {
        this.value = value;
    }

    Numeral() {
        value = 0;
    }

    @Override
    public String toString() {
        return String.format("%.0f", value);
        //return String.valueOf(value);
    }

    @Override
    public double evaluate() {
        return value;
    }
}
