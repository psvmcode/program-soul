package hot100;

import hot100.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author dongboy
 * @what time    2022/12/29 23:12
 */
public class a234回文链表 {

//    // 把链表中的数全部取出来作判断(回家等通知解法)
//    public boolean isPalindrome(ListNode head) {
//        if (head.next == null) {
//            return true;
//        }
//        List<Integer> list = new ArrayList<>();
//        while (head != null) {
//            list.add(head.val);
//            head = head.next;
//        }
//        int left = 0;
//        int right = list.size() - 1;
//        while (left < right) {
//            if (list.get(left) != list.get(right)) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }

    // 从前往后移动的节点
    ListNode frontPointer;

    // 递归解法
    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return dfs(head);
    }

    public boolean dfs(ListNode currentNode) {
        // 只关注当前节点和从后往前对应的节点
        if (currentNode != null) {
            // 一直digital找到最后一个节点，只有到最后一个节点才会返回false，否则一直是ture
            if (!dfs(currentNode.next)) {
                return false;
            }
            // 对比首尾节点的值
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            // 首节点后移
            frontPointer = frontPointer.next;
        }
        // 同时栈弹出一个元素，为尾节点的前一个节点
        return true;
    }

}
