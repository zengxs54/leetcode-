public class 斐波那契数列 {
    public static void main(String[] args) {
        System.out.println("fib(6) = " + fib(20));
    }

    /**
     * 超时了
     * @param n
     * @return
     */
    public static int fib(int n) {
        if(n<=1) return n;
        else {
            //n>=2
            if(fib(n-1)+fib(n-2)<=(1e9+7))
                return fib(n-1)+fib(n-2);
            else return 1;
        }
    }
}
