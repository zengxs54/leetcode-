package 栈和队列;

import java.util.LinkedList;

/**
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 */
public class 栈实现队列 {
    public static void main(String[] args) {
        CQueue que = new CQueue();
        System.out.println(que.toString());
    }
}

class CQueue {
    LinkedList<Integer> stack1 = null;    //队尾
    LinkedList<Integer> stack2 = null;    //队头

    public CQueue() {
        stack1 = new LinkedList();
        stack2 = new LinkedList();
    }

    public void appendTail(int value) {
        stack1.addLast(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) return stack2.removeLast();
        if (stack1.isEmpty()) return -1;
        while (!stack1.isEmpty())
            stack2.addLast(stack1.removeLast());
        return stack2.removeLast();

    }
}
