package 剑指offer第2版;

import hot100.common.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author dongboy
 * @what time    2023/1/25 18:15
 */
public class a06从尾到头打印链表 {
//    // 使用集合给返回数组赋值
//    public int[] reversePrint(ListNode head) {
//        if (head == null) {
//            return new int[]{};
//        }
//        List<Integer> list = new ArrayList<>();
//        while (head != null) {
//            list.add(head.val);
//            head = head.next;
//        }
//        int[] res = new int[list.size()];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = list.get(res.length - i - 1);
//        }
//        return res;
//    }

    // 使用栈后进先出的特点
    public int[] reversePrint(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        while (head != null) {
            deque.push(head);
            head = head.next;
        }
        int[] res = new int[deque.size()];
        int index = 0;
        while (!deque.isEmpty()) {
            res[index++] = deque.pollFirst().val;
        }
        deque = null;
        return res;
    }
}
