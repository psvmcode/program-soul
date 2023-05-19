package 剑指offer第2版;

/**
 * @Author dongboy
 * @what time    2023/2/15 22:06
 */
public class a33二叉搜索树的后序遍历序列 {
    public boolean verifyPostorder(int[] postorder) {
        return dfs(0, postorder.length - 1, postorder);
    }

    public boolean dfs(int left, int right, int[] postorder) {
        if (left >= right) {
            return true;
        }
        // temp为游标
        int temp = left;
        // 找到左子树的部分
        while (postorder[temp] < postorder[right]) {
            temp++;
        }
        // 找出根节点，其中左子树右边，根节点左边就是右子树
        int root = temp;
        while (postorder[temp] > postorder[right]) {
            temp++;
        }
        if (temp != right) {
            return false;
        }
        return dfs(left, root - 1, postorder) && dfs(root, right - 1, postorder);
    }
}
