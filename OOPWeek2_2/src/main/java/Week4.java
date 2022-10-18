public class Week4 {
    public static int max2Int(int a, int b) {
        if (a > b) {
            return a;
        }
        else return b;
    }

    public static int minArray(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) min = a[i];
        }
        return min;
    }

    public static String calculateBMI(double weight, double height) {
        double BMI;
        BMI = weight/(height * height);
        double result = Math.round(BMI*10.0)/10.0;
        if (result < 18.5) return "Thiếu cân";
        else if (result >= 18.5 && result <= 22.9) return "Bình thường";
        else if (result >= 23 && result <= 24.9) return "Thừa cân";
        else return "Béo phì";
    }
}
