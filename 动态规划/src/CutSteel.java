import java.util.HashMap;

public class CutSteel {
    /*
    * 假定我们知道Serling公司出售一段长度为i英寸的钢条的价格为p:(i=1, 2，.，单位为美元)。钢条的长度均为整英寸。图15-1给出了一个价格表的样例。
        长度i   1     2        3      4       5      6       7       8       9       10
        价格p   1     5        8      9       10     17      17      20      24      30
            如上钢条价格表样例。 每段长度为i英寸的钢条为公司带来p:美元的收益
    钢条切割问题是这样的:给定一段长度为n英寸的钢条和一个价格表p;(i=1, 2，..，n), 求切割钢条方案，使得销售收益rn最大。
    * 注意，如果长度为n英寸的钢条的价格pn足够大，最优解可能就是完全不需要切割。
    * */
    public static void main(String[] args) {
        System.out.println(Cut(17));
    }

    public static int Cut(int n) {
        int len1 = 1, len2 = 5, len3 = 8, len4 = 9, len5 = 10, len6 = 17, len7 = 17, len8 = 20, len9 = 24, len10 = 30;
        int max4 = len2+len2;   //10
        int max5 = len2+len3;   //13
        int max7 = len6+len1;   //18
        int max8 = len6+len2;   //22
        int max9 = len6+len3;   //25
        int count = 0;
        int yu = 0;
        if(n>=10){
            count = 30*(n/10);
            yu = n%10;
        } else yu = n;
        switch(yu) {
            case 1:count+=len1;break;
            case 2:count+=len2;break;
            case 3:count+=len3;break;
            case 4:count+=max4;break;
            case 5:count+=max5;break;
            case 6:count+=len6;break;
            case 7:count+=max7;break;
            case 8:count+=max8;break;
            case 9:count+=max9;break;
            default:break;
        }
        return count;
    }
    /*
    * 自下往上求解的方法
    * */
    public static int buttom_up_cut(int []p)
    {
        int []r=new int[p.length+1];
        for(int i=1;i<=p.length;i++)
        {
            int q=-1;
            for(int j=1;j<=i;j++)
                q=Math.max(q, p[j-1]+r[i-j]);
            r[i]=q;
        }
        return r[p.length];
    }
}
