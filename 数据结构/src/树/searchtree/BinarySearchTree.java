package 树.searchtree;

import 树.printer.BinaryTreeInfo;
import 树.printer.Printer;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉搜索树
 */
public class BinarySearchTree<E> implements BinaryTreeInfo {
    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    private int size;
    private Node<E> root = null;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
    }

    public void add(E element) {
        elemenrNotNullCheck(element);
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        } else {
            Node<E> node = root;
            Node<E> parent = null;
            int comp = 0;
            while (node != null) {
                comp = compare(element, node.element);
                parent = node;
                if (comp > 0) {
                    node = node.right;

                } else if (comp < 0) {
                    node = node.left;
                } else {
                    //新的覆盖旧的，add保持对象最新
                    node.element = element;
                    return;
                }
            }
            Node<E> newNode = new Node<>(element, parent);
            if (comp > 0) {
                parent.right = newNode;
            } else {
                parent.left = newNode;
            }
            size++;
        }

    }

    private int compare(E o1, E o2) {
        //传入比较器，比较器定义了比较规则
        if (comparator != null) return comparator.compare(o1, o2);
            //否则，默认传入的对象实现了可比较
        else return ((Comparable<E>) o1).compareTo(o2);
    }

    public void remove(E element) {

    }

    public void contains(E element) {

    }

    private void elemenrNotNullCheck(E element) {
        if (element == null) throw new IllegalArgumentException("element must not be null");
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>) node).element;
    }

    private static class Node<E> {
        public E element;
        public Node<E> left;
        public Node<E> right;
        public Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }

    /**
     * 提供一个访问器，用来对外公布遍历得到的element，设计模式
     *
     * @param <E>
     */
    public static abstract class Visitor<E> {
        boolean stop = false;

        abstract boolean visit(E element);
    }

    /**
     * 前序遍历
     */
    public void qianxu(Visitor<E> visitor) {
        if (visitor == null) return;
        qianxudigui(root, visitor);
    }

    private void qianxudigui(Node<E> root, Visitor<E> visitor) {
        if (root == null || visitor.stop == true) return;
        //中序后序遍历时，这一句要在递归的时候用来作判断，递归后是不是
        if (visitor.stop == true) return;
        visitor.stop = visitor.visit(root.element);
        qianxudigui(root.left, visitor);
        qianxudigui(root.right, visitor);
    }

    /**
     * 中序遍历，二叉搜索树的中序遍历是升序或者降序排列的
     */
    public void zhongxu() {

    }

    /**
     * 后序遍历，可以左右中，也可以右左中，
     */
    public void houxu() {

    }

    /**
     * 层序遍历，广度遍历
     */
    public void levelOrderTraverse() {
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        Node<E> node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            System.out.print(node.element+"， ");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

    /**
     * 计算二叉树的高度
     */
    public void getHeight() {
        System.out.println(calHeight(root));
    }

    private int calHeight(Node<E> node) {
        if (node == null)
            return 0;
        return 1 + Math.max(calHeight(node.left), calHeight(node.right));
    }

    /**
     * 判断树是否为完全二叉树
     * 右边的叶子节点为空
     */
//    public boolean isPerfectBinaryTree() {
//        //左叶子节点不为空
//    }

    /**
     * 翻转二叉树，本质上是遍历二叉树，递归前中后/层序都可以，获取到节点就左右交换
     */
    /**
     * 二叉树重构 前序+中序， 后序+中序
     * 前序+后序，如果是真二叉树，可唯一
     * 前序：421365
     * 中序：123456
     * 需求：重构和求其他遍历结果
     */

    /**
     * 前驱节点：中序遍历时，的前一个节点
     * 从左子树，一直向右遍历，或者 左子树空，
     */

}

