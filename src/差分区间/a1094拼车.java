package 差分区间;

/**
 * @Author dongboy
 * @what time    2023/1/15 12:35
 */
public class a1094拼车 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            int one = trips[i][1];
            int two = trips[i][2];
            int three = trips[i][0];
            diff[one] += three;
            diff[two] -= three;
        }
        int[] res = new int[1001];
        res[0] = diff[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}
