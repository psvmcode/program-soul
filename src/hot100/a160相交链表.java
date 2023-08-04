package hot100;

import hot100.common.ListNode;

import java.util.*;

/**
 * @Author dongboy
 * @what time    2022/12/2 21:29
 */
public class a160相交链表 {

//    // 暴力解法:把两个链表的节点分别装进两个集合，然后判断是否有一样的(回家等通知解法)
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        List<ListNode> list1 = new ArrayList<>();
//        List<ListNode> list2 = new ArrayList<>();
//        while (headA != null) {
//            list1.add(headA);
//            headA = headA.next;
//        }
//        while (headB != null) {
//            list2.add(headB);
//            headB = headB.next;
//        }
//        for (ListNode data1 : list1) {
//            for (ListNode data2 : list2) {
//                if (data1 == data2) {
//                    return data1;
//                }
//            }
//        }
//        return null;
//    }

//    // 用HashSet存储节点，只需要两次遍历(回家等通知)
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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

    // 双指针解法(手动模拟)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode one = headA;
        ListNode two = headB;
        while (one != two) {
            one = (one == null ? headB : one.next);
            two = (two == null ? headA : two.next);
        }
        return one;
    }

}
