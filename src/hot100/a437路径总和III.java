package hot100;

import hot100.common.TreeNode;

/**
 * @Author dongboy
 * @what time    2023/1/17 21:56
 */
public class a437路径总和III {

    public int pathSum(TreeNode root, int targetSum) {
        int res = 0;
        if (root == null) {
            return res;
        }
        res += rootSum(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
        return res;
    }

    public int rootSum(TreeNode root, long target) {
        int res = 0;
        if (root == null) {
            return 0;
        }
        if (root.val == target) {
            res++;
        }
        res += rootSum(root.left, (long) (target - root.val)) + rootSum(root.right, (long) (target - root.val));
        return res;
    }

}
