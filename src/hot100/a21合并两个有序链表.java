package hot100;

import hot100.common.ListNode;

/**
 * @Author dongboy
 * @what time    2022/10/27 23:13
 */
public class a21合并两个有序链表 {

    // 迭代
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        temp.next = list1 == null ? list2 : list1;
        return res.next;
    }

}
