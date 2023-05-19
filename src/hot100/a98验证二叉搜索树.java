package hot100;

import hot100.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author dongboy
 * @what time    2022/12/3 21:22
 */
public class a98验证二叉搜索树 {
    public static void main(String[] args) {

    }

    List<Integer> list;

    // 把搜索二叉树通过中序遍历变成有序集合
    public boolean isValidBST(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

//    // 递归解题
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        // 当前节点理论上的范围值
//        return dfs(root, Long.MAX_VALUE, Long.MIN_VALUE);
//    }
//
//    public boolean dfs(TreeNode root, long max, long min) {
//        // 终止条件
//        if (root == null) {
//            return true;
//        }
//        if (root.val <= min || root.val >= max) {
//            return false;
//        }
//        // 再分别看左右子树是否满足二叉搜索树
//        // 对于当前节点的左子树，最大值变为当前节点的值，最小值不变
//        boolean left = dfs(root.left, root.val, min);
//        // 对于当前节点的右子树，最小值变为当前节点的值，最大值不变
//        boolean right = dfs(root.right, max, root.val);
//        return left && right;
//    }

}
