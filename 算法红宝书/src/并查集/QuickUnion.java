package 并查集;

/**
 *quick union和quick find合并的思想：
 * 两个帮派合并，qf是一个帮派从上到下全部加入，成为新帮派小弟
 * qu是一个帮派帮主带着小弟加入另一个帮派，相对组织架构还在
 *
 *
 */
public class QuickUnion extends UnionFind {
    public QuickUnion(int capacity) {
        super(capacity);
    }

    /***
     * 将v1的根节点嫁接到v2的根节点
     * @param v1
     * @param v2
     */
    @Override
    public void union(int v1, int v2) {
        //直接找到要合并的根节点，与根节点进行合并
        int g1 = find(v1);
        int g2 = find(v2);
        if (g1 == g2) return;
        array[g1] = g2;
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        while (v != array[v]) {
            v = array[v];
        }
        return v;
    }
}
