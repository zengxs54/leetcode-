package Chapter2;

public class PaiXu {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 3, 7, 21, 16, 33, 27, 12, 7, 17};
        int[] data = Pop(arr);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    /**
     * 初级排序
     */
    public static void paiXu() {

    }

    /**
     * 选择排序
     * 原理：首先从未排序序列中找到最小的元素，放置到排序序列的起始位置，然后从剩余的未排序序列中继续寻找最小元素，放置到已排序序列的末尾。所以称之为选择排序
     * 复杂度：O(n^2)
     */
    public static int[] choose(int[] arr) {
        int min = 0;
        int len = arr.length;
        int flag = 0;
        for (int i = 0; i < len; i++) {
            min = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[min])
                    min = j;
                flag++;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        System.out.println("循环次数" + flag);
        return arr;
    }

    /**
     * 冒泡排序
     * 复杂度：O(n^2)
     */
    public static int[] Pop(int[] arr) {
        int temp = 0;
        int length = arr.length;
        int flag = 0;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] >= arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                flag++;
            }
        }
        System.out.println("循环次数" + flag);
        return arr;
    }

    /**
     * 快排
     * 原理：1.数据集中，选择一个元素作为“基准”（pivot）
     * 2，所有小于基准的元素，都移到基准的左边，大于基准的放到右边，这个操作叫“分区”（partition）操作，分区操作结束后，基准元素所在的位置就是最终排序后的位置
     * 3，对基准左右两边的子集，不断重复第一步第二步，直到所有子集只剩一个元素
     */
    public static int[] quickSort(int[] arr) {
        int len = arr.length;
        int pivot = arr[len / 2];
        int[] left = new int[len / 2];
        int[] right = new int[len / 2];
        for (int i = 0; i < len; i++) {
//            if(arr[i]>=pivot) left[]
        }
        return arr;
    }

    /**
     * 插入排序
     * 原理：1.认为第一个元素是排好序的，从第二个开始遍历。
     * 2.拿出当前元素的值，从排好序的序列中从后往前找。
     * 3， 如果序列中的元素比当前元素大，就把它后移。直到找到一个小的。
     * 4，把当前元素放在这个小的后面（后面的比当前大，它已经被后移了）
     */
    public static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;
    }
}
