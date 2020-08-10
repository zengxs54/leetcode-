package 栈和队列;

public class Heap {

}
class TreeNode<T>{
    public T data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode(T data) {
        this.data = data;
    }

    /**
     * 最大堆生成（最大二叉树）
     * @param arr
     */
    public static void maxHeapify(int[] arr, int length, int root){
        if (root >= length) {
            return;
        }

        int largest = root;
        int left = root * 2 + 1;
        int right = root * 2 + 2;

        if (left < length && arr[left] < arr[largest]) {
            largest = left;
        }

        if (right < length && arr[right] < arr[largest]) {
            largest = right;
        }

        if (largest != root) {
            int t = arr[root];
            arr[root] = arr[largest];
            arr[largest] = t;

            maxHeapify(arr, length, largest);
        }
    }
    public static void buildUpHeap(int[] arr) {
        if (arr.length <= 1)
            return;

        int n = (arr.length - 2) / 2;

        while (n >= 0) {
            maxHeapify(arr, arr.length, n);
            n--;
        }
    }
}

