public class HelloException {
    public static void main(String[] args) {
        // Phép chia này không có vấn đề
        double value = 4 / 2;
        System.out.println("Value = " + value);

        try {
            value = 2 / 0;
            System.out.println("New value = " + value);
        } catch (ArithmeticException e) {
            // Các dòng code trong khối catch được thực thi
            System.out.println("An exception");
            System.out.println("Error: " + e.getMessage());
        }
        // Dòng code dưới đây chắc chắn sẽ được thực hiện
        System.out.println("Exit!");
    }
}