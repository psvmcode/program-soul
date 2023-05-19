package hot100;

import hot100.common.TreeNode;

import java.util.*;

/**
 * @Author dongboy
 * @what time    2022/12/3 21:39
 */
public class a101对称二叉树 {
    public static void main(String[] args) {

    }

    // 递归实现
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        }
        if (!(one != null && two != null)) {
            return false;
        }
        if (one.val != two.val) {
            return false;
        }
        return dfs(one.left, two.right) && dfs(one.right, two.left);
    }

//    // 双端队列实现,每次比较双端队列两端的值是否一样并加入
//    public boolean isSymmetric(TreeNode root) {
//        Deque<TreeNode> deque = new LinkedList<>();
//        deque.offerFirst(root.left);
//        deque.offerLast(root.right);
//        while (!deque.isEmpty()) {
//            // 取出首尾的节点元素
//            TreeNode one = deque.pollFirst();
//            TreeNode two = deque.pollLast();
//            // 如果都是空则跳过当前循环
//            if (one == null && two == null) {
//                continue;
//            }
//            // 如果不是都不是空的情况
//            if (!(one != null && two != null)) {
//                return false;
//            }
//            if (one.val != two.val) {
//                return false;
//            }
//            deque.offerFirst(one.right);
//            deque.offerLast(two.left);
//            deque.offerFirst(one.left);
//            deque.offerLast(two.right);
//        }
//        return true;
//    }

}
