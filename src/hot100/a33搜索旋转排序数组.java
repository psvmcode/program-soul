package hot100;

/**
 * @Author dongboy
 * @what time    2022/11/2 19:30
 */
public class a33搜索旋转排序数组 {

//    // 遍历数组(回家等通知解法)
//    public int search(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) {
//                return i;
//            }
//        }
//        return -1;
//    }

    // 二分查找法：每次二分一定有一部分有序，一部分无序
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) { // 如果左边有序
                // 判断target是否在这个范围
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else { // 如果不在这个范围内说明在另一边
                    left = mid + 1;
                }
            } else {
                // 说明右边有序
                if (target > nums[mid] && target <= nums[right]) {
                    // 如果在这个范围内
                    left = mid + 1;
                } else {
                    // 说明不在这个范围内，在另一边
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
