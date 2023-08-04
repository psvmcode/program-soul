package hot100;

import hot100.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author dongboy
 * @what time    2023/1/14 20:58
 */
public class a61旋转链表 {

    // 把链表里的元素取出来操作(回家等通知解法)
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        List<Integer> temp = new ArrayList<>();
        k = k % list.size();
        for (int i = list.size() - k; i < list.size(); i++) {
            temp.add(list.get(i));
        }
        for (int i = 0; i < list.size() - k; i++) {
            temp.add(list.get(i));
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int i = 0; i < list.size(); i++) {
            cur.next = new ListNode(temp.get(i));
            cur = cur.next;
        }
        return dummy.next;
    }

}
