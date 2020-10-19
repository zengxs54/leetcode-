package 排序.sort;

public class BubbleSort1 extends Sort {
    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            for (int start = 1; start <= end; start++) {
                if (cmp(array[start], array[start - 1]) < 0) {
                    swap(start, start - 1);
                }
            }
        }
    }
}
