package hot100;

import hot100.common.ListNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author dongboy
 * @what time    2022/12/4 21:40
 */
public class a148排序链表 {
    public static void main(String[] args) {
    }

    // 暴力解法:取出所有数字后排序,再创建新的链表后返回(回家等通知解法)
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        for (int i = 0; i < list.size(); i++) {
            temp.next = new ListNode(list.get(i));
            temp = temp.next;
        }
        return dummy.next;
    }
}
