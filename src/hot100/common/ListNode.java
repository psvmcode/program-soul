package hot100.common;

/**
 * @Author dongboy
 * @what time    2022/10/27 16:43
 */
public class ListNode {

    public int val;

    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
