package 剑指offer第2版;

import hot100.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author dongboy
 * @what time    2023/2/17 21:55
 */
public class a34二叉树中和为某一值的路径 {

    // 经典回溯
    List<List<Integer>> res;
    List<Integer> path;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        dfs(root, target, path);
        return res;
    }

    public void dfs(TreeNode root, int target, List<Integer> path) {
        if (root == null) {
            return;
        }
        target -= root.val;
        path.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        dfs(root.left, target, path);
        dfs(root.right, target, path);
        path.remove(path.size() - 1);
        return;
    }

}
