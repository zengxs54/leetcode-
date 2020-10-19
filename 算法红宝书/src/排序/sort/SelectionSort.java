package 排序.sort;

public class SelectionSort extends Sort {

    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            int max = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(array[max], array[begin]) < 0) {
                    max = begin;
                }
            }
            swap(max, end);
        }
    }
}
