package 剑指offer第2版;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author dongboy
 * @what time    2023/2/3 23:04
 */
public class a11旋转数组的最小数字 {

//    // 暴力排序(回家等通知)
//    public int minArray(int[] numbers) {
//        Arrays.sort(numbers);
//        return numbers[0];
//    }

//    // 暴力遍历(回家等通知)
//    public int minArray(int[] numbers) {
//        int res = Integer.MAX_VALUE;
//        for (int i = 0; i < numbers.length; i++) {
//            res = Math.min(res, numbers[i]);
//        }
//        return res;
//    }

    // 二分：数组最后一个元素x，最小值右侧的元素值小于等于x，最小值左侧的元素值大于等于x
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (numbers[mid] < numbers[right]) {
                // 说明mid对应的元素是最小值右侧的元素
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                // 说明mid对应的元素在最小值左边
                left = mid + 1;
            } else {
                // 相等说明有重复元素，直接向左移动
                right--;
            }
        }
        return numbers[left];
    }

}
