package hot100;

import hot100.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author dongboy
 * @what time    2022/12/4 20:13
 */
public class a104二叉树的最大深度 {

    // 递归深度优先实现
    public int maxDepth(TreeNode root) {
        // 终止条件，当前空节点
        if (root == null) {
            return 0;
        }
        // 计算左子树的最大深度
        int one = 0;
        if (root.left != null) {
            one = maxDepth(root.left);
        }
        // 计算右子树的最大深度
        int two = 0;
        if (root != null) {
            two = maxDepth(root.right);
        }
        // 分别看左右子树的最大深度
        return Math.max(one, two) + 1;
    }

//    // 队列广度优先实现
//    public int maxDepth(TreeNode root) {
//        int res = 0;
//        if (root == null) {
//            return res;
//        }
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            res++;
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode curNode = queue.poll();
//                if (curNode.left != null) {
//                    queue.offer(curNode.left);
//                }
//                if (curNode.right != null) {
//                    queue.offer(curNode.right);
//                }
//            }
//        }
//        return res;
//    }

}
