package hot100;

import hot100.common.TreeNode;

/**
 * @Author dongboy
 * @what time    2022/12/2 20:32
 */
public class a124二叉树中的最大路径和 {

    // 利用最大子数组和的思想
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        method(root);
        return res;
    }

    public int method(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 递归计算当前节点的左右子树的最大贡献值
        // 只选择贡献值大于0的节点
        int left = Math.max(method(root.left), 0);
        int right = Math.max(method(root.right), 0);
        res = Math.max(res, left + right + root.val);
        return root.val + Math.max(left, right); // 只能选择一边。不能同时选择两条贡献路径
    }

}
