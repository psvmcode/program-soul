package hot100;

/**
 * @Author dongboy
 * @what time    2023/1/31 16:37
 */
public class a240搜索二维矩阵II {

//    // 暴力(回家等通知解法)
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int m = matrix.length;
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

//    // 二分查找法
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int m = matrix.length;
//        int n = matrix[0].length;
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

    // 把矩阵逆时针旋转45度，成为二叉搜索树
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

}
