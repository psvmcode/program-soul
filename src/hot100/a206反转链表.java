package hot100;

import hot100.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author dongboy
 * @what time    2022/12/14 13:51
 */
public class a206反转链表 {
    public static void main(String[] args) {

    }

    // 迭代法解题
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        // pre ---> cur ---> temp
        while (cur != null) {
            ListNode temp = cur.next; // 缓存
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
