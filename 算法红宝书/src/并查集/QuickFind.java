package 并查集;

/***
 * quick find 查找和union均为logn
 */
public class QuickFind extends UnionFind {

    public QuickFind(int capcaity) {
        super(capcaity);
    }

    /**
     * 将v1集合上所有元素都嫁接到v2的父节点上
     * @param v1
     * @param v2
     */
    @Override
    public void union(int v1, int v2) {
        int g1 = array[v1];
        int g2 = array[v2];
        if (g1 == g2) return;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == g1) {
                array[i] = g2;
            }
        }
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        return array[v];
    }
}
