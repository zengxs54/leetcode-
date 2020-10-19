package 排序.assist;

public class BinarySearch<T> {
    //二分查找，找到第一个适合插入的位置，即及一个大于插入值的位置
    public static int searchInsertPosition(int[] arr, int val) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        //2,3,6,8,11,11,14
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = (end + start) >> 1;
            if (val < arr[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
