package 排序.sort;

import 排序.assist.BinarySearch;

import java.util.Arrays;

public class InsertSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    protected void sort() {
//        for (int begin = 1; begin < array.length; begin++) {
//            int cur = begin;
//            T val = array[cur];
//            //优化方案1：大于cur的排序过的部分整体向右移
//            while (cur > 0 && cmp(val, array[cur - 1]) < 0) {
//                array[cur] = array[cur-1];
//                cur--;
//            }
//            array[cur] = val;
//        }
        //优化方案2：左边有序部分二分搜索，找到第一个大于代排序的位置
        for (int begin = 1; begin < array.length; begin++) {
            insert(begin, search(begin));
        }
    }

    /**
     * 将source位置的元素插入到dest位置
     * @param source
     * @param dest
     */
    private void insert(int source, int dest) {
        T v = array[source];
        for (int i = source; i > dest; i--) {
            array[i] = array[i - 1];
        }
        array[dest] = v;
    }

    /**
     * 利用二分搜索找到 index 位置元素的待插入位置
     * 已经排好序数组的区间范围是 [0, index)
     * @param index
     * @return
     */
    private int search(int index) {
        int begin = 0;
        int end = index;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (cmp(array[index], array[mid]) < 0) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }
}
