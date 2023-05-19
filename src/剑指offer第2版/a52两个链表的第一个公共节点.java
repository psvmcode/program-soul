package 剑指offer第2版;

import hot100.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author dongboy
 * @what time    2023/2/19 16:20
 */
public class a52两个链表的第一个公共节点 {

//    // 用set
//    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        Set<ListNode> set = new HashSet<>();
//        while (headA != null) {
//            set.add(headA);
//            headA = headA.next;
//        }
//        while (headB != null) {
//            if (set.contains(headB)) {
//                return headB;
//            }
//            headB = headB.next;
//        }
//        return null;
//    }

    // 双指针:待证明，建议直接背
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode one = headA;
        ListNode two = headB;
        while (one != two) {
            one = (one == null ? headB : one.next);
            two = (two == null ? headA : two.next);
        }
        return one;
    }
}
