package 差分区间;

/**
 * @Author dongboy
 * @what time    2023/1/15 12:47
 */
public class a1854人口最多的年份 {

    public int maximumPopulation(int[][] logs) {
        int[] diff = new int[102];
        for (int i = 0; i < logs.length; i++) {
            int one = logs[i][0] - 1950;
            int two = logs[i][1] - 1950;
            diff[one]++;
            diff[two]--;
        }
        int[] nums = new int[101];
        nums[0] = diff[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + diff[i];
        }
        int res = 1950;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] > max) {
                max = nums[i];
                res = i + 1950;
            }
        }
        return res;
    }

}
