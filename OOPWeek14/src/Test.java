import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = {1, 3, 2, 5, 4};
        Context context1 = new Context(new BubbleSort());
        context1.executeSort(array);
        System.out.println(Arrays.toString(array));

        Context context2 = new Context(new SelectionSort());
        context2.executeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
