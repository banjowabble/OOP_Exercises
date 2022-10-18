public class ClientTest {
    public static void main(String[] args) {
        //test Fibonacci
        System.out.println(Solution.fibonacci(8));

        //test GCD
        System.out.println(Solution.gcd(-12, 16));

        //test Prime
        System.out.println(Solution.isPrime(5));

        //test fraction
        Solution fraction1 = new Solution(1,2);
        Solution fraction2 = new Solution(3,4);

        //test function add
        fraction1.add(fraction2);
        System.out.println(fraction1.getNumerator() + "/" + fraction1.getDenominator());

        //test function subtract
        fraction1.subtract(fraction2);
        System.out.println(fraction1.getNumerator() + "/" + fraction1.getDenominator());

        //test function multiply
        fraction1.multiply(fraction2);
        System.out.println(fraction1.getNumerator() + "/" + fraction1.getDenominator());

        //test function divide
        fraction1.divide(fraction2);
        System.out.println(fraction1.getNumerator() + "/" + fraction1.getDenominator());
    }
}
