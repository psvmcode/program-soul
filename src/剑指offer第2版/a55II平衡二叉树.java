package 剑指offer第2版;

import hot100.common.TreeNode;

/**
 * @Author dongboy
 * @what time    2023/2/22 21:51
 */
public class a55II平衡二叉树 {

    // dfs
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(maxDeepth(root.left) - maxDeepth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDeepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDeepth(root.left), maxDeepth(root.right)) + 1;
    }

}
