package hot100;

/**
 * @Author dongboy
 * @what time    2022/11/5 20:42
 */
public class a48旋转图像 {

    // 原地解法:旋转90度其实就是每一步同时转换4个元素，这四个元素分别关于正方形对角线对称
    // 时间O(n^2) 空间O(1)
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                // 四个数状态转移，倒推
                // 从当前数到第四个位置依次是 s1 s2 s3 s4
                // s4的值先复制给s1，s3的值赋值给s4，s2的值赋值给s3，s1的值事先被temp暂缓起来，直接将temp赋值给s4
                // 关键在于根据第一个点找到其他三个点之间的坐标
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }


//    // 利用辅助数组解题(回家等通知解法) 时间o(n^2) 空间O(n^2)
//    public void rotate(int[][] matrix) {
//        int n = matrix.length;
//        int[][] temp = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                // 这里利用矩阵旋转的数学规律，第i行j列的元素旋转90度后到达第j行第n-i-1列
//                temp[j][n - i - 1] = matrix[i][j];
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                matrix[i][j] = temp[i][j];
//            }
//        }
//    }

}
