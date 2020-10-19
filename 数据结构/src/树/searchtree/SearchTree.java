package 树.searchtree;

public interface SearchTree<E> {
    int size();

    boolean isEmpty();
    void clear();
    void add(E element);
    void remove(E element);
    void contains(E element);
}
