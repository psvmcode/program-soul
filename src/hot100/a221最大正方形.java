package hot100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author dongboy
 * @what time    2023/1/31 16:22
 */
public class a221最大正方形 {

    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 第i行中以第j行结尾的连续1的个数
                if (matrix[i][j] == '1') {
                    nums[i][j] = (j == 0 ? 1 : nums[i][j - 1] + 1);
                }
            }
        }
        for (int j = 0; j < n; j++) {
            // 对于每列，以柱状图求最大面积的方式求解
            Deque<Integer> deque = new ArrayDeque<>();
            int[] left = new int[m];
            int[] right = new int[m];
            Arrays.fill(right, m);
            for (int i = 0; i < m; i++) {
                while (!deque.isEmpty() && nums[deque.peekFirst()][j] >= nums[i][j]) {
                    right[deque.pollFirst()] = i;
                }
                left[i] = deque.isEmpty() ? -1 : deque.peekFirst();
                deque.push(i);
            }
            deque = null;
            for (int i = 0; i < m; i++) {
                res = Math.max(res, Math.min(right[i] - left[i] - 1, nums[i][j]) * Math.min(right[i] - left[i] - 1, nums[i][j]));
            }
        }
        return res;
    }

}
