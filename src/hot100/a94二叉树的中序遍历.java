package hot100;

import hot100.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author dongboy
 * @what time    2022/12/3 16:34
 */
public class a94二叉树的中序遍历 {

//    List<Integer> res;
//
//    // 回溯
//    public List<Integer> inorderTraversal(TreeNode root) {
//        res = new ArrayList<>();
//        dfs(root);
//        return res;
//    }
//
//    public void dfs(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        dfs(root.left);
//        res.add(root.val);
//        dfs(root.right);
//    }


//    List<Integer> res = new ArrayList<>();
//
//    // 回溯2
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root == null) {
//            return res;
//        }
//        inorderTraversal(root.left);
//        res.add(root.val);
//        inorderTraversal(root.right);
//        return res;
//    }

    // 迭代:利用栈实现 对于栈顶元素，如果有左节点，则把左节点入栈，如果没有左节点则右节点入栈，如果都没有则出栈，并把val加进结果集
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

}
