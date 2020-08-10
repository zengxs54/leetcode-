public class 求和 {
    public static void main(String[] args) {
        System.out.println("sumNums(9) = " + sumNums(8));
    }

    public static int sumNums(int n) {
        //位运算：与（&）：都是1的话返回1 ，否则为0
        //       或（|）： 1个为1，返回1.2个为0，返回0
        //       取反（~）：1变0，0变1
        //      异或（^）:值相同为1，不同为0
        //      位移<<<,>>>
        //
        //使用逻辑运算的阻断性
        boolean zero = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
        //等差数列求和公式
//        return (int) (Math.pow(n, 2) + n) >> 1;
    }
}
