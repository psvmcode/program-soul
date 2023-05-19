package 剑指offer第2版;

import hot100.common.ListNode;
import hot100.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author dongboy
 * @what time    2023/2/19 17:01
 */
public class a54 {

//    // 暴力遍历
//    List<Integer> list;
//
//    public int kthLargest(TreeNode root, int k) {
//        list = new ArrayList<>();
//        dfs(root);
//        return list.get(list.size() - k);
//    }
//
//    public void dfs(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        dfs(root.left);
//        list.add(root.val);
//        dfs(root.right);
//    }

    // 中序遍历+提前返回
    int res;
    int k;

    public int kthLargest(TreeNode root, int k) {
        this.res = 0;
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            res = root.val;
        }
        dfs(root.left);
    }

}
