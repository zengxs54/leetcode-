package 并查集;

/***
 * quick union 的rank优化+路径压缩优化
 */
public class QuickUnion_Rank_PathCompress extends QuickUnion_Rank{
    public QuickUnion_Rank_PathCompress(int capacity) {
        super(capacity);
    }
    @Override
    public int find(int v) {
        //把v的路径上的所有节点都指向根节点，把这条路径高度降低成2，但是增加了路径解析成本
        rangeCheck(v);
        if (array[v] != v) {
            array[v] = find(array[v]);
        }
        return array[v];
    }
}
