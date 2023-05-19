package hot100;

import hot100.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author dongboy
 * @what time    2022/12/2 21:11
 */
public class a141环形链表 {
    public static void main(String[] args) {

    }

//    // 利用Set集合判断是否存在环
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> set = new HashSet<>();
//        while (head != null) {
//            if (set.contains(head)) {
//                return true;
//            }
//            set.add(head);
//            head = head.next;
//        }
//        return false;
//    }

    // 龟兔赛跑算法(快慢指针)
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) { // 兔子先走完说明没有环，有环则兔子不可能走完
                return false;
            }
            slow = slow.next; // 乌龟走一步
            fast = fast.next.next; // 兔子走两步
        }
        return true;
    }

}
