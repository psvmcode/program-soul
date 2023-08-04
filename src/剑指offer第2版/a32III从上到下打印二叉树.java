package 剑指offer第2版;

import hot100.common.TreeNode;

import java.util.*;

/**
 * @Author dongboy
 * @what time    2023/2/15 21:26
 */
public class a32III从上到下打印二叉树 {

    // 层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if ((index & 1) == 0) {
                res.add(list);
            } else {
                Collections.reverse(list);
                res.add(list);
            }
            index++;
            list = null;
        }
        return res;
    }

}
