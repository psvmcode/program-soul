package 剑指offer第2版;

import hot100.common.TreeNode;

/**
 * @Author dongboy
 * @what time    2023/2/13 20:49
 */
public class a28对称的二叉树 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return method(root, root);
    }

    public boolean method(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return method(left.left, right.right) && method(left.right, right.left);
    }

}
