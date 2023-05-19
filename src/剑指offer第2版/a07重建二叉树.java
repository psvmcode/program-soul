package 剑指offer第2版;

import hot100.common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author dongboy
 * @what time    2023/2/3 21:29
 */
public class a07重建二叉树 {

    // key为中序中的节点，value为节点在中序中的位置
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder,
                0, inorder.length - 1,
                0, inorder.length - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder,
                                 int left_preorder, int right_preorder,
                                 int left_inorder, int right_inorder) {
        if (left_preorder > right_preorder) {
            return null;
        }
        // 前序第一个节点为根节点
        int root_preorder = left_preorder;
        // 在中序遍历中定位根节点
        int root_inorder = map.get(preorder[root_preorder]);
        // 建立根节点
        TreeNode root = new TreeNode(preorder[root_preorder]);
        // 得到左子树的节点数 = 中序中根节点下标 - 左边界节点下标
        int size_left = root_inorder - left_inorder;
        // 递归构建左子树
        root.left = myBuildTree(preorder, inorder,
                left_preorder + 1, left_preorder + size_left,
                left_inorder, root_inorder - 1);
        // 递归构建右子树
        root.right = myBuildTree(preorder, inorder,
                left_preorder + size_left + 1, right_preorder,
                root_inorder + 1, right_inorder);
        return root;
    }


}
