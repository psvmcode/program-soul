package hot100;


/**
 * @Author dongboy
 * @what time    2022/10/21 12:49
 */
public class a4寻找两个正序数组的中位数 {

    // 优化解法,双指针
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 第一个数组中的下标
        int one = 0;
        // 第二个数组中的下标
        int two = 0;
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0) {
            return (double) nums2[nums2.length / 2];
        }
        if (n == 0) {
            return (double) nums1[nums1.length / 2];
        }
        while (one < m || two < n) {
            //当左边的数最多相差一个的时候，就是相等
            int top = one;
            int topest = Math.max(0, m - one - 1);
            int bot = two;
            int botest = Math.max(0, n - bot - 1);
            if (Math.abs(top - topest + bot - botest) == 0) {
                return (double) (nums1[one] + nums2[two]) / 2;
            } else if (Math.abs(top - topest + bot - botest) == 1) {
                // 找到偏大的那个
                if (nums1[one] >= nums2[two]) {
                    // 和另一个的右边比较，返回两者最小值
                    int temp = Integer.MAX_VALUE;
                    if (two < n - 1) {
                        temp = nums2[two + 1];
                    }
                    return (double) Math.min(nums1[one], temp);
                } else {
                    int temp = Integer.MAX_VALUE;
                    if (one < m - 1) {
                        temp = nums1[one + 1];
                    }
                    return (double) Math.min(nums2[two], temp);
                }
            } else {
                if (nums1[one] <= nums2[two]) {
                    if (one < m - 1) {
                        one++;
                    } else {
                        two++;
                    }
                } else {
                    if (two < n - 1) {
                        two++;
                    } else {
                        one++;
                    }
                }
            }
        }
        return -1;
    }

    // 回去等通知解法 合并后排序求中位数
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int[] nums = new int[nums1.length + nums2.length];
//        for (int i = 0; i < nums1.length; i++) {
//            nums[i] = nums1[i];
//        }
//        for (int i = 0; i < nums2.length; i++) {
//            nums[i + nums1.length - 1] = nums2[i];
//        }
//        Arrays.sort(nums);
//        return nums.length % 2 == 1 ?
//                (double) (nums[nums.length / 2]) :
//                (double) (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2;
//    }
}
