package hot100;

import hot100.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author dongboy
 * @what time    2023/1/24 19:02
 */
public class a105从前序与中序遍历序列构造二叉树 {

    Map<Integer, Integer> map; // key为节点的值,value为中序中的位置

    // 迭代构造树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder,
                0, inorder.length - 1,
                0, inorder.length - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder,
                                int preorder_left, int preorder_right,
                                int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        // 前序第一个节点为根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = map.get(preorder[preorder_root]);
        // 建立根节点
        TreeNode root = new TreeNode(preorder[preorder_left]);
        // 得到左子树中节点数目
        int left_size = inorder_root - inorder_left;
        // 递归构造左子树
        root.left = myBuildTree(preorder, inorder,
                preorder_left + 1, preorder_left + left_size,
                inorder_left, inorder_root - 1);
        // 递归构造右子树
        root.right = myBuildTree(preorder, inorder,
                preorder_left + left_size + 1, preorder_right,
                inorder_root + 1, inorder_right);
        return root;
    }
}
