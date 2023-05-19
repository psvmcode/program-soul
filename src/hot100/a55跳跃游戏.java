package hot100;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author dongboy
 * @what time    2022/11/10 20:00
 */
public class a55跳跃游戏 {
    public static void main(String[] args) {
    }

    // 贪心解法
    public boolean canJump(int[] nums) {
        int mod = (int) (1e9 + 7);
        int n = nums.length;
        int right = 0;
        for (int i = 0; i < n; i++) {
            if (i <= right) {
                right = Math.max(right, i + nums[i]);
                if (right >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }


//    // 队列实现广度优先
//    public boolean canJump(int[] nums) {
//        Queue<Integer> queue = new ArrayDeque<>();
//        int n = nums.length;
//        if (n == 1) {
//            return true;
//        }
//        boolean[] flag = new boolean[n];
//        queue.offer(0);
//        flag[0] = true;
//        while (!queue.isEmpty()) {
//            // 如果不在队列，就进队列，否则出队
//            int cur = queue.poll();
//            int left = cur + 1;
//            int right = cur + nums[cur];
//            for (int i = left; i <= right; i++) {
//                // 如果到终点就返回
//                if (i == n - 1) {
//                    return true;
//                } else {
//                    if (!flag[i]) { // 如果没加进来过，就加进来，剪枝操作
//                        queue.offer(i);
//                        flag[i] = true;
//                    }
//                }
//            }
//        }
//        return false;
//    }


}
