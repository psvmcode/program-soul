package hot100;

import hot100.common.TreeNode;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * @Author dongboy
 * @what time    2022/12/15 12:16
 */
public class a226翻转二叉树 {
    public static void main(String[] args) {

    }

//    // 用队列实现广度优先
//    public TreeNode invertTree(TreeNode root) {
//        // 空树直接返回
//        if (root == null) {
//            return root;
//        }
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode cur = queue.poll();
//                // 交换当前节点的左右子树节点
//                TreeNode temp = cur.left;
//                cur.left = cur.right;
//                cur.right = temp;
//                if (cur.left != null) {
//                    queue.offer(cur.left);
//                }
//                if (cur.right != null) {
//                    queue.offer(cur.right);
//                }
//            }
//        }
//        return root;
//    }

    // 递归实现
    public TreeNode invertTree(TreeNode root) {
        // 终止条件，为空直接返回
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
