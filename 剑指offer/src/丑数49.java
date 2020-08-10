import java.util.ArrayList;

public class 丑数49 {
    /**
     * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     * 输入: n = 10
     * 输出: 12
     * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("nthUglyNumber(7) = " + nthUglyNumber(11));
    }

    public static int nthUglyNumber(int n) {
        //7，11，13，17，19，21，23，26，29，31，33
        //求出n以内有几个非丑数
        int count = 0;
        int num = 1;
        while (count < n) {
            if(num<11){
                if(num !=7)
                    count++;
            } else {
                if(num%10 ==1||num%10 ==3 || num%10 == 7||num%10 ==9 ||num%7==0){

                } else
                    count++;
            }
            num++;
        }
        return num-1;
    }
}
