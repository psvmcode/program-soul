package 差分区间;

/**
 * @Author dongboy
 * @what time    2023/1/15 12:41
 */
public class a1893检查是否区域内所有整数都被覆盖 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[51];
        for (int i = 0; i < ranges.length; i++) {
            int one = ranges[i][0] - 1;
            int two = ranges[i][1] - 1;
            diff[one]++;
            diff[two + 1]--;
        }
        int[] res = new int[50];
        res[0] = diff[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        for (int i = left; i <= right; i++) {
            if (res[i - 1] < 1) {
                return false;
            }
        }
        return true;
    }
}
