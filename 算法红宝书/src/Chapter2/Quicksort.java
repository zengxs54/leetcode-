package Chapter2;

/**
 * 快速排序
 * 分类：1.单轴快速排序
 * 2.三向切分的快速排序
 * 3.双轴快速排序
 */
public class Quicksort {
    public static void main(String[] args) {
        int[] arr = new int[]{12, 7, 3, 21, 8, 14, 11, 9, 32, 19, 22, 21};
        quickSort1(arr, 0, arr.length - 1);
    }

    /**
     * 算法名称：单轴快速排序
     * 原理：1.数据集中，选择一个元素作为“基准”（pivot）
     * 2，所有小于基准的元素，都移到基准的左边，大于基准的放到右边，这个操作叫“分区”（partition）操作，分区操作结束后，基准元素所在的位置就是最终排序后的位置
     * 3，对基准左右两边的子集，不断重复第一步第二步，直到所有子集只剩一个元素
     */
    public static void singlePivotQuicksort(int[] A, int L, int R) {

    }

    /**
     * 元素切分方式：从两端扫描，元素交换
     * 基本思想：使用两个变量i和j，i指向首元素的元素下一个元素（最左边的首元素为中轴元素），j指向最后一个元素，我们从前往后找，直到找到一个比中轴元素大的，
     * 然后从后往前找，直到找到一个比中轴元素小的，然后交换这两个元素，直到这两个变量交错（i > j）（注意不是相遇 i == j，因为相遇的元素还未和中轴元素比较）。
     * 最后对左半数组和右半数组重复上述操作。
     *
     * @param A
     * @param L
     * @param R
     */
    public static void quickSort1(int[] A, int L, int R) {
        if (L < R) { //递归条件，L == R时，数组长度为1
            int pivot = A[L];
            int i = L + 1, j = R;
            //当i == j时，i和j同时指向的元素还没有与中轴元素判断，
            //小于等于中轴元素，i++,大于中轴元素j--,
            //当循环结束时，一定有i = j+1, 且i指向的元素大于中轴，j指向的元素小于等于中轴
            while (i <= j) {
                while (i <= j && A[i] < pivot) i++;
                while (i <= j && A[j] > pivot) j--;
                System.out.println("i = " + i);
                System.out.println("j = " + j);
            }
            //i>j时停止切分，停止交换值
            //进行交换
            if (i < j) {
                Swap(A, i, j);
                i++;
                j--;
            }
            //当循环结束时，j指向的元素是最后一个（从左边算起）小于等于中轴的元素
            Swap(A, L, j);//将中轴元素和j所指的元素互换
            quickSort1(A, L, j - 1);//递归左半部分
            quickSort1(A, j + 1, R);//递归右半部分
        }
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }

    /**
     * 元素切分方式：从两端扫描，一边挖坑，一边填坑
     * 基本思想，使用两个变量i和j，i指向最左边的元素，j指向最右边的元素，我们将首元素作为中轴，将首元素复制到变量pivot中，这时我们可以将首元素i所在的位置看成一个坑，
     * 我们从j的位置从右向左扫描，找一个小于等于中轴的元素A[j]，来填补A[i]这个坑，填补完成后，拿去填坑的元素所在的位置j又可以看做一个坑，
     * 这时我们在以i的位置从前往后找一个大于中轴的元素来填补A[j]这个新的坑，如此往复，直到i和j相遇（i == j，此时i和j指向同一个坑）。
     * 最后我们将中轴元素放到这个坑中。最后对左半数组和右半数组重复上述操作。
     *
     * @param A
     * @param L
     * @param R
     */
    public static void quickSort2(int[] A, int L, int R) {
        if (L < R) {
            //最左边的元素作为中轴复制到pivot，这时最左边的元素可以看做一个坑
            int pivot = A[L];
            //注意这里 i = L,而不是 i = L+1, 因为i代表坑的位置,当前坑的位置位于最左边
            int i = L, j = R;
            while (i < j) {
                //下面面两个循环的位置不能颠倒，因为第一次坑的位置在最左边
                while (i < j && A[j] > pivot) {
                    j--;
                }
                //填A[i]这个坑,填完后A[j]是个坑
                //注意不能是A[i++] = A[j],当因i==j时跳出上面的循环时
                //坑为i和j共同指向的位置,执行A[i++] = A[j],会导致i比j大1，
                //但此时i并不能表示坑的位置
                A[i] = A[j];

                while (i < j && A[i] <= pivot) {
                    i++;
                }
                //填A[j]这个坑，填完后A[i]是个坑，
                //同理不能是A[j--] = A[i]
                A[j] = A[i];
            }
            //循环结束后i和j相等，都指向坑的位置，将中轴填入到这个位置
            A[i] = pivot;

            quickSort2(A, L, i - 1);//递归左边的数组
            quickSort2(A, i + 1, R);//递归右边的数组
        }
    }

    /**
     * 元素切分方式：单端扫描
     *
     * @param A
     * @param L
     * @param R
     */
    public static void quickSort3(int[] A, int L, int R) {

    }

    public static void threeWayQuicksort() {

    }

    /**
     * 双轴快排
     * 思路：双轴快速排序算法思路和三向切分快速排序算法的思路基本一致，双轴快速排序算法使用两个轴，通常选取最左边的元素作为pivot1和最右边的元素作pivot2。
     * 首先要比较这两个轴的大小，如果pivot1 > pivot2，则交换最左边的元素和最右边的元素，已保证pivot1 <= pivot2。双轴快速排序同样使用i，j，k三个变量将数组分成四部分。
     * <p>
     * A[L+1, i]是小于pivot1的部分，A[i+1, k-1]是大于等于pivot1且小于等于pivot2的部分，A[j, R]是大于pivot2的部分，而A[k, j-1]是未知部分。和三向切分的快速排序算法一样，
     * 初始化i = L，k = L+1，j=R，k自左向右扫描直到k与j相交为止（k == j）。我们扫描的目的就是逐个减少未知元素，并将每个元素按照和pivot1和pivot2的大小关系放到不同的区间上去。
     * 在k的扫描过程中我们可以对a[k]分为三种情况讨论（注意我们始终保持最左边和最右边的元素，即双轴，不发生交换）
     * <p>
     * （1）a[k] < pivot1 i先自增，交换a[i]和a[k]，k自增1，k接着继续扫描
     * <p>
     * （2）a[k] >= pivot1 && a[k] <= pivot2 k自增1，k接着继续扫描
     * <p>
     * （3）a[k] > pivot2: 这个时候显然a[k]应该放到最右端大于pivot2的部分。但此时，我们不能直接将a[k]与j的下一个位置a[--j]交换（可以认为A[j]与pivot1和pivot2的大小关系
     * 在上一次j自右向左的扫描过程中就已经确定了，这样做主要是j首次扫描时避免pivot2参与其中），因为目前a[--j]和pivot1以及pivot2的关系未知，
     * 所以我们这个时候应该从j的下一个位置（--j）自右向左扫描。而a[--j]与pivot1和pivot2的关系可以继续分为三种情况讨论
     * <p>
     * 3.1）a[--j] > pivot2 j接着继续扫描
     * <p>
     * 3.2）a[--j] >= pivot1且a[j] <= pivot2 交换a[k]和a[j]，k自增1，k继续扫描（注意此时j的扫描就结束了）
     * <p>
     * 3.3） a[--j] < pivot1 先将i自增1，此时我们注意到a[j] < pivot1,  a[k] > pivot2,  pivot1 <= a[i] <=pivot2，那么我们只需要将a[j]放到a[i]上，a[k]放到a[j]上，
     * 而a[i]放到a[k]上。k自增1，然后k继续扫描（此时j的扫描就结束了）
     * <p>
     * 注意
     * <p>
     * 1. pivot1和pivot2在始终不参与k，j扫描过程。
     * <p>
     * 2. 扫描结束时，A[i]表示了小于pivot1部分的最后一个元素，A[j]表示了大于pivot2的第一个元素，这时我们只需要交换pivot1（即A[L]）和A[i]，交换pivot2（即A[R]）与A[j]，
     * 同时我们可以确定A[i]和A[j]所在的位置在后续的排序过程中不会发生变化（这一步非常重要，否则可能引起无限递归导致的栈溢出），最后我们只需要对A[L, i-1]，A[i+1, j-1]，A[j+1, R]
     * 这三个部分继续递归上述操作即可。
     */
    public static void dualPivotQuicksort(int[] A, int L, int R) {
        if (L >= R) return;
        if (A[L] > A[R]) Swap(A, L, R);
        int pivot1 = A[L];
        int pivot2 = A[R];

        int i = L, k = L + 1, j = R;
        OUT_LOOP:
        while (k < j) {
            if (A[k] < pivot1) {
                i++;//pivot1不变，所以让i+1再交换
                Swap(A, i, k);
                k++;
            } else if (pivot1 <= A[k] && A[k] <= pivot2) {
                k++;
            } else {
                while (A[--j] > pivot2) {   //让pivot2不改变，需要--j
                    if (j <= k) {   //j和k相遇
                        break OUT_LOOP;
                    }
                }
                if (A[j] > pivot1 && A[j] < pivot2) {
                    Swap(A, k, j);
                    k++;
                } else {
                    i++;
                    Swap(A, j, k);
                    Swap(A, i, k);
                    k++;
                }
            }
        }
        Swap(A, L, i);//将pivot1交换到适当位置
        Swap(A, R, j);//将pivot2交换到适当位置
        //一次双轴切分至少确定两个元素的位置，这两个元素将整个数组区间分成三份
        dualPivotQuicksort(A, L, i - 1);
        dualPivotQuicksort(A, i + 1, j - 1);
        dualPivotQuicksort(A, j + 1, R);
    }

    /**
     * 交换数组中两个元素值
     *
     * @param A
     * @param i
     * @param j
     */
    public static void Swap(int[] A, int i, int j) {
        int tmp;
        tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
