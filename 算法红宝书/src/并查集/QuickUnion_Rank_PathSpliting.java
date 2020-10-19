package 并查集;

/**
 * 路径分裂，路径上每个节点指向其祖父节点
 * 最终的并查集优化路线
 * quick union + rank + path spliting
 */
public class QuickUnion_Rank_PathSpliting extends QuickUnion_Rank {
    public QuickUnion_Rank_PathSpliting(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        while (v != array[v]) {
            int temp = array[v];
            array[v] = array[array[v]];
            v = temp;
        }
        return v;
    }
}
