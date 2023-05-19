package hot100;

/**
 * @Author dongboy
 * @what time    2023/1/21 17:36
 */
public class a238除自身以外数组的乘积 {
    // 前缀和解题
    public int[] productExceptSelf(int[] nums) {
        int[] dp1 = new int[nums.length]; // dp1[i]表示i前面所有数的和
        int[] dp2 = new int[nums.length];
        dp1[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            dp1[i] = dp1[i - 1] * nums[i - 1];
        }
        dp2[nums.length - 2] = nums[nums.length - 1];
        for (int i = nums.length - 3; i >= 0; i--) {
            dp2[i] = dp2[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                nums[0] = dp2[0];
                continue;
            }
            if (i == nums.length - 1) {
                nums[nums.length - 1] = dp1[nums.length - 1];
                break;
            }
            nums[i] = dp1[i] * dp2[i];
        }
        return nums;
    }
}
