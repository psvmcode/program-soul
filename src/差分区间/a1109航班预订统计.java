package 差分区间;

/**
 * @Author dongboy
 * @what time    2023/1/15 12:31
 */
public class a1109航班预订统计 {
    public static void main(String[] args) {

    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 1];
        for (int i = 0; i < bookings.length; i++) {
            int one = bookings[i][0] - 1;
            int two = bookings[i][1] - 1;
            int three = bookings[i][2];
            diff[one] += three;
            diff[two + 1] -= three;
        }
        int[] res = new int[n];
        res[0] = diff[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

}
