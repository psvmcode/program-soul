package hot100;

import hot100.common.ListNode;

import java.util.*;

/**
 * @Author dongboy
 * @what time    2022/12/21 10:48
 */
public class a142环形链表II {
    public static void main(String[] args) {

    }

//    // 用set集合存储并判断是否有环
//    public ListNode detectCycle(ListNode head) {
//        Set<ListNode> set = new HashSet<>();
//        while (head != null) {
//            if (set.contains(head)) {
//                return head;
//            }
//            set.add(head);
//            head = head.next;
//        }
//        return null;
//    }

    // 双指针:当falst和slow在环内相遇时，额外用一个temp指针从头结点出发，和slow同步向后移动一个位置，两者一定会在入环点i相遇
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        // 快指针，兔子
        ListNode fast = head;
        // 慢指针，乌龟
        ListNode slow = head;
        // 只要不相遇，就一直跑，相遇说明遇到了
        while (fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            }
            // 快指针走一步
            fast = fast.next.next;
            // 如果快慢指针相遇
            if (fast == slow) {
                ListNode temp = head;
                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        return null;
    }

}
