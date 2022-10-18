public class ExpressionTest {
    public static Numeral ten = new Numeral(10);
    public static Numeral three = new Numeral(3);
    public static Numeral four = new Numeral(4);

    public static Square tenSquared = new Square(ten);
    public static Subtraction subtraction = new Subtraction(tenSquared, three);
    public static Multiplication multiplication = new Multiplication(four, three);
    public static Addition addition = new Addition(subtraction, multiplication);
    public static Square sumSquared = new Square(addition);

    public static Numeral one = new Numeral(1);
    public static Numeral zero = new Numeral(0);
    public static Division division = new Division(one, zero);

    public static void main(String[] args) {
        System.out.println(sumSquared);
        System.out.println(sumSquared.evaluate());
        System.out.println(division);
        System.out.println(division.evaluate());
    }
}
