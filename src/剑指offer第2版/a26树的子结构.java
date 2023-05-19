package 剑指offer第2版;

import hot100.common.TreeNode;

/**
 * @Author dongboy
 * @what time    2023/2/13 17:05
 */
public class a26树的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // A本身和B一样
        // A的左子树和B一样
        // A的右子树和B一样
        if (A == null || B == null) {
            return false;
        }
        return method(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean method(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return method(A.left, B.left) && method(A.right, B.right);
    }
}
