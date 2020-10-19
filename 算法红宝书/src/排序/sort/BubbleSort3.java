package 排序.sort;

/**
 * 一点点优化，假如输出的数据有序，直接跳过交换的步骤
 */
public class BubbleSort3<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            int sortIndex = 1;
            for (int start = 1; start <= end; start++) {
                if (cmp(array[start], array[start - 1]) < 0) {
                    swap(start, start - 1);
                    sortIndex = start;
                }
            }
            end = sortIndex;
        }
    }

}
