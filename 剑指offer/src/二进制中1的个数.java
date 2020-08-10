import java.util.Stack;

public class 二进制中1的个数 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(3186261));
    }

    /**
     * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        //判断最后一位是0还是1
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }
}
