package 排序.sort;

import java.util.Collections;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        sort(0, array.length);
    }

    private void sort(int begin, int end) {
        if (end - begin < 2) return;
        int mid = pivotIndex(begin, end);
        sort(begin, mid);
        sort(mid + 1, end);
    }

    private int pivotIndex(int begin, int end) {
        //让end下标指向值
        end--;
        //让头部的轴点随机
        swap(begin, begin + (int) (Math.random() * (end - begin))); //就是在begin-end之间取个值与begin交换
        //备份轴点数据
        T pivot = array[begin];
        while (begin < end) {
            while (begin < end) {
                if (cmp(pivot, array[end]) < 0) {   //右边元素>轴元素，不交换
                    end--;
                } else {
                    array[begin++] = array[end];
                    break;
                }
            }
            while (begin < end) {
                if (cmp(pivot, array[begin]) > 0) {      //轴>左元素，不交换
                    begin++;
                } else {
                    array[end--] = array[begin];        //轴<=左元素，这个元素放到右边
                    break;
                }
            }
        }
        array[begin] = pivot;
        return begin;
    }
}
