package 排序.sort;

public class BubbleSort2 extends Sort {
    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            boolean sorted = true;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(array[begin], array[begin - 1]) < 0) {
                    swap(begin, begin - 1);
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }
}
