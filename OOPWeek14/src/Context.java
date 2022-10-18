public class Context {
    private Sort sort;

    public Context(Sort sort) {
        this.sort = sort;
    }

    public void executeSort(int[] array) {
        sort.sort(array);
    }
}
