package 剑指offer第2版;

import hot100.common.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author dongboy
 * @what time    2023/2/17 22:18
 */
public class a35复杂链表的复制 {

    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        if (!map.containsKey(head)) {
            Node cur = new Node(head.val);
            map.put(head, cur);
            cur.next = copyRandomList(head.next);
            cur.random = copyRandomList(head.random);
        }
        return map.get(head);
    }

}
