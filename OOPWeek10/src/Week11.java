import java.util.List;

public class Week11 {
    /**
     * sort a generic list.
     * @param arr array to be sorted
     * @param <T> generic type
     * @return the sorted array
     */
    public static <T> List<T> sortGeneric(List<T> arr) {
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (less(arr.get(j), arr.get(j - 1))) {
                    exchange(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    /**
     * check if a is less than b.
     * @param a a
     * @param b b
     * @param <T> generic type
     * @return an integer < 0 if less, > 0 if more, 0 if equal
     */
    public static <T> boolean less(T a, T b) {
        if (a instanceof Integer && b instanceof Integer) {
            return ((Integer) a).compareTo((Integer) b) < 0;
        } else if (a instanceof String && b instanceof String) {
            return ((String) a).compareTo((String) b) < 0;
        } else {
            assert a instanceof Person;
            return ((Person) a).compareTo((Person) b) < 0;
        }
    }

    /**
     * exchange two elements of a list.
     * @param arr the list
     * @param i index i
     * @param j index j
     * @param <T> generic type
     */
    public static <T> void exchange(List<T> arr, int i, int j) {
        T temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
