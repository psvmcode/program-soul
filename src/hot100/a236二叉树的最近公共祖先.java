package hot100;

import hot100.common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author dongboy
 * @what time    2023/1/21 18:35
 */
public class a236二叉树的最近公共祖先 {
    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        res = null;
        dfs(root, p, q);
        return res;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if ((left && right) || ((root.val == p.val || root.val == q.val) && (left || right))) {
            res = root;
        }
        return left || right || (root.val == p.val || root.val == q.val);
    }
}
