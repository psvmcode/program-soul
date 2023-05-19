package hot100;

/**
 * @Author dongboy
 * @what time    2022/12/8 21:16
 */
public class a494目标和 {
    public static void main(String[] args) {
        System.out.println(Integer.toString(21, 3));
    }

//    // 回溯解题
//    public int findTargetSumWays(int[] nums, int target) {
//        return dfs(nums, target, 0);
//    }
//
//    public int dfs(int[] nums, int target, int index) {
//        // 终止条件，到最后一行终止，然后看是否满足target为0
//        if (index == nums.length) {
//            return target == 0 ? 1 : 0;
//        }
//        return dfs(nums, target - nums[index], index + 1) + dfs(nums, target + nums[index], index + 1);
//    }

    // 动态规划解法:背包问题暂时不会
    public int findTargetSumWays(int[] nums, int target) {
        return 1;
    }

}
