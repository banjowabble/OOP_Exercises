import java.util.Arrays;

public class BubbleSort implements Sort{
    @Override
    public int[] sort(int[] array) {
        Arrays.sort(array);
        return array;
    }
}
