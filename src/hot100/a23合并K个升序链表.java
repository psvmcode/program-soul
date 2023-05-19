package hot100;

import hot100.common.ListNode;

/**
 * @Author dongboy
 * @what time    2022/10/30 22:59
 */
public class a23合并K个升序链表 {
    public static void main(String[] args) {

    }

    // 分治解法，多路同时计算
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        ListNode one = merge(lists, left, mid);
        ListNode two = merge(lists, mid + 1, right);
        return mergeTwoListNode(one, two);
    }

    public ListNode mergeTwoListNode(ListNode one, ListNode two) {
        if (one == null || two == null) {
            return one == null ? two : one;
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (one != null && two != null) {
            if (one.val <= two.val) {
                temp.next = one;
                one = one.next;
            } else {
                temp.next = two;
                two = two.next;
            }
            temp = temp.next;
        }
        temp.next = one == null ? two : one;
        return dummy.next;
    }

//    // 顺序两两合并 每次都是两个链表之间的排序 把大问题分割成n-1个两两合并问题·
//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode res = null;
//        for (ListNode curNode : lists) {
//            res = mergeTwoListNode(res, curNode);
//        }
//        return res;
//    }
//
//    public ListNode mergeTwoListNode(ListNode res, ListNode curNode) {
//        if (res == null || curNode == null) {
//            return res == null ? curNode : res;
//        }
//        ListNode dummy = new ListNode(-1);
//        ListNode temp = dummy;
//        while (res != null && curNode != null) {
//            if (res.val <= curNode.val) {
//                temp.next = res;
//                res = res.next;
//            } else {
//                temp.next = curNode;
//                curNode = curNode.next;
//            }
//            temp = temp.next;
//        }
//        temp.next = res == null ? curNode : res;
//        return dummy.next;
//    }

//    // 顺序两两合并 每次都是两个链表之间的排序 把大问题分割成n-1个两两合并问题·
//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode res = null;
//        for (ListNode curNode : lists) {
//            // 合并res和当前链表的当前元素
//            if (res == null || curNode == null) {
//                res = res == null ? curNode : res;
//                continue;
//            }
//            ListNode curRes = new ListNode(-1);
//            ListNode curres = curRes;
//            while (res != null && curNode != null) {
//                if (res.val < curNode.val) {
//                    curres.next = res;
//                    res = res.next;
//                } else {
//                    curres.next = curNode;
//                    curNode = curNode.next;
//                }
//                curres = curres.next;
//            }
//            curres.next = curNode == null ? res : curNode;
//            res = curRes.next;
//        }
//        return res;
//    }

    // 把所有节点的值装进集合后排序，然后重新装进链表里(回去等通知解法)
//    public ListNode mergeKLists(ListNode[] lists) {
//        List<Integer> list = new ArrayList<>();
//        for (ListNode data : lists) {
//            while (data != null) {
//                list.add(data.val);
//                data = data.next;
//            }
//        }
//        Collections.sort(list);
//        ListNode res = new ListNode(-1);
//        ListNode res = res;
//        for (int data : list) {
//            res.next = new ListNode(data);
//            res = res.next;
//        }
//        return res.next;
//    }

}
