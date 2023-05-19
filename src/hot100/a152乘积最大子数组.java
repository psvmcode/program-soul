package hot100;

/**
 * @Author dongboy
 * @what time    2022/12/5 22:45
 */
public class a152乘积最大子数组 {
    public static void main(String[] args) {

    }

    // 贪心
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 每一步计算最大和最小的值
            int preMax = max;
            int preMin = min;
            // 每一步最大值是 1.之前最大值×当前值 2.之前最小值×当前值 3.当前值 三者中的最大值
            max = Math.max(preMax * nums[i], Math.max(preMin * nums[i], nums[i]));
            min = Math.min(preMax * nums[i], Math.min(preMin * nums[i], nums[i]));
            res = Math.max(max, res);
        }
        return res;
    }

}
