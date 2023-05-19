package 剑指offer第2版;

import hot100.common.ListNode;

/**
 * @Author dongboy
 * @what time    2023/2/13 17:01
 */
public class a25合并两个排序的链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = (l1 == null ? l2 : l1);
        return res.next;
    }

}
