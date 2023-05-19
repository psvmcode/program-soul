package 剑指offer第2版;

/**
 * @Author dongboy
 * @what time    2023/2/13 21:11
 */
public class a29顺时针打印矩阵 {

    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new int[]{};
        }
        int n = matrix[0].length;
        if (n == 0) {
            return new int[]{};
        }
        int[] res = new int[m * n];
        int index = 0;
        int shang = 0;
        int xia = m - 1;
        int zuo = 0;
        int you = n - 1;
        while (shang <= xia && zuo <= you) {
            // 从左到右
            for (int i = zuo; i <= you; i++) {
                res[index++] = matrix[shang][i];
            }
            // 从上到下
            for (int i = shang + 1; i <= xia; i++) {
                res[index++] = matrix[i][you];
            }
            if (zuo < you && shang < xia) {
                // 从右到左
                for (int i = you - 1; i >= zuo; i--) {
                    res[index++] = matrix[xia][i];
                }
                // 从下到上
                for (int i = xia - 1; i > shang; i--) {
                    res[index++] = matrix[i][zuo];
                }
            }
            shang++;
            xia--;
            zuo++;
            you--;
        }
        return res;
    }

}
