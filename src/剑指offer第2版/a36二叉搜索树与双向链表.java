package 剑指offer第2版;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author dongboy
 * @what time    2023/3/21 17:45
 */
public class a36二叉搜索树与双向链表 {

    public class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

//    List<Node> list;
//
//    public Node treeToDoublyList(Node root) {
//        list = new ArrayList<>();
//        dfs(root);
//        for (int i = 1; i < list.size(); i++) {
//            // 上一个节点
//            Node pre = list.get(i - 1);
//            Node cur = list.get(i);
//            pre.right = cur;
//            cur.left = pre;
//        }
//        list.get(0).left = list.get(list.size() - 1);
//        list.get(list.size() - 1).right = list.get(0);
//        return list.get(0);
//    }
//
//    public void dfs(Node root) {
//        if (root == null) {
//            return;
//        }
//        dfs(root.left);
//        list.add(root);
//        dfs(root.right);
//    }

    Node pre;
    Node head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        // 头尾节点的互相指向
        head.left = pre;
        pre.right = head;
        dfs(root);
        return head;
    }

    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        // pre表示root左边的节点
        dfs(root.left);
        // 当pre不为空，说明当前root不是头节点
        if (pre != null) {
            pre.right = root;
        } else { // 当pre为null时，也就是root左侧没有节点，说明此时root是链表头节点
            head = root;
        }
        // pre是否为空不影响当前节点指向
        root.left = pre;
        // 把pre指向root后继续迭代
        pre = root;
        dfs(root.right);
    }
}
