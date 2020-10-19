package 并查集;

import java.util.Arrays;

/**
 *优化方案：
 * 基于size优化：元素少的加到元素多的树
 * 基于rank优化：树矮的加到树高的  √
 */
public abstract class UnionFind {
    protected int[] array;

    public UnionFind(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("容量大小错误");
        }
        array = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = i;
        }
    }

    protected abstract void  union(int v1, int v2);
    protected  abstract int find(int v);

    public boolean isSame(int v1, int v2) {
        return find(v1) == find(v2);
    }
    protected void rangeCheck(int v) {
        if (v < 0 || v >= array.length) {
            throw new IndexOutOfBoundsException("下标超限制");
        }
    }
    @Override
    public String toString(){
        return Arrays.toString(array);
    }
}
