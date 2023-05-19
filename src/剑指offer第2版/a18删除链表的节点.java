package 剑指offer第2版;

import hot100.common.ListNode;

/**
 * @Author dongboy
 * @what time    2023/2/5 15:20
 */
public class a18删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
}
