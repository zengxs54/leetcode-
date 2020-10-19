package 并查集;

import org.junit.Test;

public class TestUnion {
    @Test
    public void testQuickUnion() {
        QuickFind qf = new QuickFind(12);
        qf.union(4, 0);
        qf.union(3, 0);
        qf.union(3, 2);
        qf.union(2, 5);
        qf.union(1, 0);

        qf.union(6, 7);

        qf.union(8, 9);
        qf.union(8, 10);
        qf.union(9, 11);
        System.out.println(qf.toString());
        System.out.println("qf.isSame(4,6) = " + qf.isSame(4, 6));
        qf.union(6,3);
        System.out.println("qf.isSame(3,6) = " + qf.isSame(3, 6));
        System.out.println(qf.toString());
        System.out.println("=============================================================");
        QuickUnion_Rank_PathCompress qu = new QuickUnion_Rank_PathCompress(12);
//        QuickUnion qu = new QuickUnion(12);
        qu.union(4, 0);
        qu.union(3, 0);
        qu.union(3, 2);
        qu.union(2, 5);
        qu.union(0, 1);

        qu.union(6, 7);

        qu.union(8, 9);
        qu.union(8, 10);
        qu.union(9, 11);

        System.out.println(qu.toString());
        System.out.println("qu.isSame(3,5) = " + qu.isSame(3, 5));
        System.out.println("qu.isSame(1,2) = " + qu.isSame(1, 2));
        System.out.println("qu.isSame(1,3) = " + qu.isSame(1, 3));
        System.out.println("qu.isSame(4, 6) = " + qu.isSame(4, 6));
        qu.union(6,3);
        System.out.println("qu.isSame(4,6) = " + qu.isSame(4, 6));
        System.out.println(qu.toString());
    }
}
