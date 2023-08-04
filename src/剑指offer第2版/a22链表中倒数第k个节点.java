package 剑指offer第2版;

import hot100.common.ListNode;

/**
 * @Author dongboy
 * @what time    2023/2/13 16:31
 */
public class a22链表中倒数第k个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        // 右指针往后走
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = dummy;
        while (k > 0) {
            k--;
            right = right.next;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        return left.next;
    }

}
