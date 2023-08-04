package hot100;

/**
 * @Author dongboy
 * @what time    2022/10/24 23:04
 */
public class a11盛最多水的容器 {

    // 回去等通知解法
//    public int maxArea(int[] height) {
//        int res = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
//            }
//        }
//        return res;
//    }


    // 贪心基础上加上减枝思维
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            int minHigh = Math.min(height[left], height[right]);
            while (left < right && height[left] <= minHigh) {
                left++;
            }
            while (right > left && height[right] <= minHigh) {
                right--;
            }
        }
        return res;
    }

    // 贪心步步最优
//    public int maxArea(int[] height) {
//        int left = 0;
//        int right = height.length - 1;
//        int res = 0;
//        while (left < right) {
//            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
//            if (height[left] < height[right]) {
//                left++;
//            } else {
//                right--;
//            }
//        }
//        return res;
//    }

}
