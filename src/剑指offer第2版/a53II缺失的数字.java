package 剑指offer第2版;

/**
 * @Author dongboy
 * @what time    2023/2/19 16:55
 */
public class a53II缺失的数字 {

//    // O(n)时间
//    public int missingNumber(int[] nums) {
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//        }
//        return (nums.length + 1) * nums.length / 2 - sum;
//    }

    // O(n)时间
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (res != nums[i]) {
                return res;
            }
            res++;
        }
        return res;
    }

}
