package hot100;

import com.sun.xml.internal.ws.api.message.Packet;

import java.util.*;

/**
 * @Author dongboy
 * @what time    2022/12/9 20:05
 */
public class a85最大矩形 {

    // 采用柱状图最大面积的做法
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    // 当前第i行中，以j列结尾的连续1的个数
                    nums[i][j] = (j == 0 ? 1 : nums[i][j - 1] + 1);
                }
            }
        }
        int res = 0;
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
                res = Math.max(res, (right[i] - left[i] - 1) * nums[i][j]);
            }
        }
        return res;
    }

//    // 暴力解法(回家等通知解法)
//    public int maximalRectangle(char[][] matrix) {
//        // 找出所有是1的位置，挨个遍历
//        List<int[]> list = new ArrayList<>();
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] == '1') {
//                    list.add(new int[]{i, j});
//                }
//            }
//        }
//        int res = 0;
//        if (list.size() > 0) {
//            res = 1;
//        }
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = i + 1; j < list.size(); j++) {
//                boolean flag = true;
//                int x1 = list.get(i)[0];
//                int y1 = list.get(i)[1];
//                int x2 = list.get(j)[0];
//                int y2 = list.get(j)[1];
//                for (int m = x1; m <= x2; m++) {
//                    for (int n = y1; n <= y2; n++) {
//                        if (matrix[m][n] != '1') {
//                            flag = false;
//                            break;
//                        }
//                    }
//                    if (!flag) {
//                        break;
//                    }
//                }
//                if (flag) {
//                    res = Math.max(res, (x2 - x1 + 1) * (y2 - y1 + 1));
//                }
//            }
//        }
//        return res;
//    }

}
