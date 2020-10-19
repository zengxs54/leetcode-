package 排序;

import org.junit.Before;
import org.junit.Test;
import 并查集.QuickFind;
import 并查集.QuickUnion;
import 排序.assist.BinarySearch;
import 排序.sort.*;
import 排序.tools.Asserts;
import 排序.tools.Integers;

import java.util.Arrays;

public class SortTest {
    Integer[] arr;

    @Before
    public void before() {
        arr = Integers.random(10000, 1, 40000);
//        arr = new Integer[]{7,3,1,11,2,9,14,22,15,18,27,24,5};
    }

    @Test
    public void test() {
//        System.out.println("原始数据为："+Arrays.toString(arr));
        testSort(
                new BubbleSort3(),
                new SelectionSort(),
                new InsertSort(),
                new HeapSort(),
                new QuickSort()
        );
    }

    public void testSort(Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(arr);
            sort.sort(newArray);

            Asserts.test(Integers.isAscOrder(newArray));
//            System.out.println( sort.getClass().getName()+"排序结果:"+Arrays.toString(newArray));
        }
        Arrays.sort(sorts);
        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }

    @Test
    public void binarySearchTest() {
        int[] arr = new int[]{2, 3, 6, 8, 11, 11, 14};
        int i = BinarySearch.searchInsertPosition(arr, 7);
        System.out.println("插入的位置 = " + i);
    }

}
