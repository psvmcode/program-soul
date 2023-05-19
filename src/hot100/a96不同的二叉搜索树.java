package hot100;

/**
 * @Author dongboy
 * @what time    2022/12/3 19:27
 */
public class a96不同的二叉搜索树 {
    public static void main(String[] args) {

    }

    // 假设n个节点存在二叉排序树的个数是G(n)，
    // 1为根节点，2为根节点，...，n为根节点，
    // 当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，
    // 同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2，
    // 所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
    // 动态规划+二叉搜索树特性
    public int numTrees(int n) {
        int res = 0;
        int[] dp = new int[n + 1];
        // 0个节点只有一种
        dp[0] = 1;
        // 1个节点只有一种
        dp[1] = 1;
        // dp[i]表示i个节点构成的二叉搜索树的种类
        for (int i = 2; i <= n; i++) {
            // 以序号为j的节点为顶点构成的二叉搜索树
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j]; // 左边j-1个，右边i-j个，每种情况要叠加起来
            }
        }
        return dp[n];
    }

}
