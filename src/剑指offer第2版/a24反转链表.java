package 剑指offer第2版;

import hot100.common.ListNode;

/**
 * @Author dongboy
 * @what time    2023/2/13 16:55
 */
public class a24反转链表 {

    // 迭代
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    // 递归 todo

}
