package 剑指offer第2版;

import hot100.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author dongboy
 * @what time    2023/2/13 20:34
 */
public class a27二叉树的镜像 {

//    // 回溯
//    public TreeNode mirrorTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        TreeNode temp = mirrorTree(root.left);
//        root.left = mirrorTree(root.right);
//        root.right = temp;
//        return root;
//    }

    // 层序遍历
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return root;
    }

}
