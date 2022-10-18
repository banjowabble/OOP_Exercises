public class Solution {
    /**
     * Calculate fibonacci number of index n.
     * @param n index of the fibonacci number
     * @return fibonacci number of index n
     */
    public static long fibonacci(long n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            long a0 = 0;
            long a1 = 1;
            long result = 0;
            for (int i = 2; i <= n; i++) {
                result = a0 + a1;
                a0 = a1;
                a1 = result;
            }
            if (result < 0) {
                return Long.MAX_VALUE;
            } else {
                return result;
            }
        }
    }

    /**
     * check if an integer is a prime number.
     * @param n an integer
     * @return boolean check
     */
    public static boolean isPrime(int n) {
        if (n < 0 || n == 0 || n == 1) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * find the greatest common divider.
     * @param a first number
     * @param b second number
     * @return gcd of a and b
     */
    public static int gcd(int a, int b) {
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private int numerator;
    private int denominator = 1;

    public int getNumerator() {
        return this.numerator;
    }

    public void setNumerator(int num) {
        this.numerator = num;
    }

    public int getDenominator() {
        return this.denominator;
    }

    /**
     * set denominator.
     * @param den desired denominator
     */
    public void setDenominator(int den) {
        if (den != 0) {
            this.denominator = den;
        }
    }

    Solution(int numerator, int denominator) {
        this.setNumerator(numerator);
        if (denominator != 0) {
            this.setDenominator(denominator);
        }
    }

    /**
     * reduce the fraction.
     * @return the reduced fraction
     */
    public Solution reduce() {
        int gcd = Solution.gcd(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
        return this;
    }

    /**
     * add two fractions.
     * @param other the other fraction
     * @return the added fraction
     */
    public Solution add(Solution other) {
        this.numerator = this.numerator * other.denominator + other.numerator * this.denominator;
        this.denominator = this.denominator * other.denominator;
        this.reduce();
        return this;
    }

    /**
     * subtract two fractions.
     * @param other the other fraction
     * @return the subtracted fraction
     */
    public Solution subtract(Solution other) {
        this.numerator = this.numerator * other.denominator - other.numerator * this.denominator;
        this.denominator = this.denominator * other.denominator;
        this.reduce();
        return this;
    }

    /**
     * multiply two fractions.
     * @param other the other fraction
     * @return the multiplied fraction
     */
    public Solution multiply(Solution other) {
        this.numerator *= other.numerator;
        this.denominator *= other.denominator;
        this.reduce();
        return this;
    }

    /**
     * divide two fractions.
     * @param other the other fraction
     * @return the divided fraction
     */
    public Solution divide(Solution other) {
        if (other.numerator != 0) {
            this.numerator *= other.denominator;
            this.denominator *= other.numerator;
            this.reduce();
        }
        return this;
    }

    /**
     * compare a fraction and an object if they are equal.
     * @param obj the other object
     * @return boolean check
     */
    public boolean equals(Object obj) {
        if (obj instanceof Solution) {
            Solution other = (Solution) obj;
            other.reduce();
            this.reduce();
            return other.numerator == this.numerator && other.denominator == this.denominator;
        }
        return false;
    }
}
