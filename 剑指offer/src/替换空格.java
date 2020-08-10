import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class 替换空格 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2};
        ListNode node =new ListNode(1);
        node.next  = new ListNode(3);
        node.next.next = new ListNode(2);
        reversePrint().toString();
    }

    public static int[] reversePrint() {
        ListNode head =new ListNode(1);
        head.next  = new ListNode(3);
        head.next.next = new ListNode(2);
        LinkedList<Integer> stack=  new LinkedList<>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = stack.removeFirst();
        return res;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
