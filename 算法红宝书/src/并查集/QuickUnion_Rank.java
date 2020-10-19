package 并查集;

public class QuickUnion_Rank extends QuickUnion {
    int[] ranks;           //记录要合并的树的高度

    public QuickUnion_Rank(int capacity) {
        super(capacity);
        ranks = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            ranks[i] = 1;
        }
    }

    @Override
    public void union(int v1, int v2) {
        int g1 = find(v1);
        int g2 = find(v2);
        if (g1 == g2) return;
        /***
         * 如果左树比右树高，右树根节点合并到左树根节点
         */
        if (ranks[g1] < ranks[g2]) {
            array[g1] = g2;
        } else if (ranks[g1] > ranks[g2]) {
            array[g2] = g1;
        } else {
            array[g1] = g2;
            ranks[g2] += 1;
        }
    }
}
