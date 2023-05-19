package hot100;

import com.sun.jmx.remote.internal.ArrayQueue;
import hot100.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author dongboy
 * @what time    2022/12/2 19:23
 */
public class a114二叉树展开为链表 {
    public static void main(String[] args) {

    }

    //    List<TreeNode> list;
//
//    // 将树的所有节点放入集合，然后手动形成二叉树
//    public void flatten(TreeNode root) {
//        list = new ArrayList<>();
//        method(root);
//        for (int i = 1; i < list.size(); i++) {
//            // 本来是左子树的，要变成右子树
//            TreeNode pre = list.get(i - 1); // 获取前一个节点
//            TreeNode cur = list.get(i);
//            pre.left = null;
//            pre.right = cur;
//        }
//    }
//
//    public void method(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        list.add(root);
//        method(root.left);
//        method(root.right);
//    }

}
