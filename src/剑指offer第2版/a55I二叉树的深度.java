package 剑指offer第2版;

import hot100.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author dongboy
 * @what time    2023/2/22 21:38
 */
public class a55I二叉树的深度 {

    // dfs
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

//    // bfs
//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        Deque<TreeNode> deque = new ArrayDeque<>();
//        deque.offer(root);
//        int res = 0;
//        while (!deque.isEmpty()) {
//            res++;
//            int size = deque.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode cur = deque.poll();
//                if (cur.left != null) {
//                    deque.offer(cur.left);
//                }
//                if (cur.right != null) {
//                    deque.offer(cur.right);
//                }
//            }
//        }
//        return res;
//    }
}
