package hot100;

import hot100.common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @Author dongboy
 * @what time    2022/10/27 16:43
 */
public class a19删除链表的倒数第N个结点 {

    // 双指针，维持一个长为n+1的双指针，第二个指针走到链表尾，第一个指针指向的下一个元素就是要删除的元素
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        // 设置虚拟头节点
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode left = dummy;
//        ListNode right = dummy;
//        // 第二个指针向前走n+1步
//        for (int i = 0; i < n + 1; i++) {
//            right = right.next;
//        }
//        if (right == null) {
//            left.next = left.next.next;
//            return dummy.next;
//        }
//        while (right != null) {
//            left = left.next;
//            right = right.next;
//        }
//        left.next = left.next.next;
//        return dummy.next;
//    }

//    // 栈:将所有结点入栈存储，弹出来的第n个节点就是所求节点
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        Deque<ListNode> deque = new ArrayDeque<>();
//        // 设置头节点，方便计算
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode temp = dummy;
//        while (temp != null) {
//            deque.push(temp);
//            temp = temp.next;
//        }
//        // 找到倒数第n个节点的前驱
//        for (int i = 0; i < n; i++) {
//            deque.pop();
//        }
//        ListNode pre = deque.peek();
//        pre.next = pre.next.next;
//        return dummy.next;
//    }

    // 计算长度(回家等通知)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sum = 0;
        ListNode temp = head;
        while (temp != null) {
            sum++;
            temp = temp.next;
        }
        temp = head;
        for (int i = 0; i < sum - n - 1; i++) {
            temp = temp.next;
        }
        if (temp != null && temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
    }

}
