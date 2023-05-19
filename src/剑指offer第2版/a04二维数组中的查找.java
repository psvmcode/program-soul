package 剑指offer第2版;

/**
 * @Author dongboy
 * @what time    2023/1/25 15:23
 */
public class a04二维数组中的查找 {

//    // 暴力遍历(回家等通知)
//    public boolean findNumberIn2DArray(int[][] matrix, int target) {
//        int m = matrix.length;
//        if (m == 0) {
//            return false;
//        }
//        int n = matrix[0].length;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == target) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

//    // 每行都递增，使用二分法查找
//    public boolean findNumberIn2DArray(int[][] matrix, int target) {
//        int m = matrix.length;
//        if (m == 0) {
//            return false;
//        }
//        int n = matrix[0].length;
//        if (n == 0) {
//            return false;
//        }
//        for (int i = 0; i < m; i++) {
//            if (matrix[i][0] <= target && matrix[i][n - 1] >= target) {
//                int left = 0;
//                int right = n - 1;
//                while (left <= right) {
//                    int mid = (left + right) >> 1;
//                    if (matrix[i][mid] == target) {
//                        return true;
//                    } else if (matrix[i][mid] < target) {
//                        left = mid + 1;
//                    } else {
//                        right = mid - 1;
//                    }
//                }
//            }
//        }
//        return false;
//    }

    // 将矩阵逆时针旋转45度，当作二叉查找树
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        if (matrix[0].length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1; // 列
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                // 向右变大
                i++;
            } else {
                // 向左变小
                j--;
            }
        }
        return false;
    }
}
