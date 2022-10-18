import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Week8Task2 {
    public static void nullPointerEx() {
        Integer integer = null;
        String string = integer.toString();
    }

    /**
     * test null pointer exception.
     * @return exception info
     */
    public static String nullPointerExTest() {
        try {
            nullPointerEx();
        } catch (NullPointerException e) {
            return ("Lỗi Null Pointer");
        }
        return ("Không có lỗi");
    }

    public static void arrayIndexOutOfBoundsEx() {
        int[] a = new int[1];
        int b = a[1];
    }

    /**
     * test index out of bounds exception.
     * @return exception info
     */
    public static String arrayIndexOutOfBoundsExTest() {
        try {
            arrayIndexOutOfBoundsEx();
        } catch (ArrayIndexOutOfBoundsException e) {
            return ("Lỗi Array Index Out of Bounds");
        }
        return ("Không có lỗi");
    }

    /**
     * arithmetic exception example.
     */
    public static void arithmeticEx() {
        int a = 1;
        int b = 0;
        int c = a / b;
    }

    /**
     * test arithmetic exception.
     * @return exception info
     */
    public static String arithmeticExTest() {
        try {
            arithmeticEx();
        } catch (ArithmeticException e) {
            return ("Lỗi Arithmetic");
        }
        return ("Không có lỗi");
    }

    public static void fileNotFoundEx() throws FileNotFoundException {
        FileReader fileReader = new FileReader("unknown.txt");
    }

    /**
     * test file not found exception.
     * @return exception info
     */
    public static String fileNotFoundExTest() {
        try {
            fileNotFoundEx();
        } catch (FileNotFoundException e) {
            return ("Lỗi File Not Found");
        }
        return ("Không có lỗi");
    }

    public static void ioEx() throws IOException {
        FileReader fileReader = new FileReader("unknown.txt");
    }

    /**
     * test IO exception.
     * @return exception info
     */
    public static String ioExTest() {
        try {
            fileNotFoundEx();
        } catch (FileNotFoundException e) {
            return ("Lỗi IO");
        }
        return ("Không có lỗi");
    }

    public static void main(String[] args) {
        System.out.println(nullPointerExTest());
        System.out.println(arrayIndexOutOfBoundsExTest());
        System.out.println(arithmeticExTest());
        System.out.println(fileNotFoundExTest());
        System.out.println(ioExTest());
    }
}
