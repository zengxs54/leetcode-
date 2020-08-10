public class Test1 {
    /**
     * 动态规划解决方法：
     * 1）自上向下的备忘录法
     * 2）自下向上 √
     */
    public static void main(String[] args) {
        //斐波那契数列问题求解
        System.out.println(callBack(5));

    }
    /*备忘录法*/
    public static int Fib(int n){
        if(n<=0)
            return n;
        int []Memo=new int[n+1];
        for(int i=0;i<=n;i++)
            Memo[i]=-1;
        return fib(n, Memo);
    }
    public static int fib(int n,int []Memo)
    {
        if(Memo[n]!=-1)
            return Memo[n];
        //如果已经求出了fib（n）的值直接返回，否则将求出的值保存在Memo备忘录中。
        if(n<=2)
            Memo[n]=1;

        else Memo[n]=fib( n-1,Memo)+fib(n-2,Memo);
        return Memo[n];
    }
    /*自下往上回溯法*/
    static int callBack(int n){
//        if(n <=1) return n;
//        int Memo_i_2 = 0;
//        int Memo_i_1 = 1;
//        int Memo_i = 1;
//
//        for(int i = 2; i <= n; i++){
//            Memo_i = Memo_i_2 + Memo_i_1;
//            Memo_i_2 = Memo_i_1;
//            Memo_i_1 = Memo_i;
//        }
//        return Memo_i;

        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    /**
     * 也是回溯法
     * @param n
     * @return
     */
    public int fff(int n) {
        if(n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

}
