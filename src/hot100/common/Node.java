package hot100.common;

/**
 * @Author dongboy
 * @what time    2023/2/17 22:18
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
