package hot100;

import hot100.common.ListNode;

/**
 * @Author dongboy
 * @what time    2022/10/20 22:34
 */
public class a2两数相加 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        int cur = 0; // 当前值
        int add = 0; // 增数
        while (l1 != null || l2 != null) {
            int one = 0;
            int two = 0;
            if (l1 != null) {
                one = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                two = l2.val;
                l2 = l2.next;
            }
            int sum = add + one + two; // 当前总和
            cur = sum % 10; // 当前数
            add = sum / 10; // 加数
            temp.next = new ListNode(cur);
            temp = temp.next;
        }
        if (add > 0) {
            temp.next = new ListNode(add);
        }
        return res.next;
    }
}

