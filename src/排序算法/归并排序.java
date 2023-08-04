package 排序算法;

import 排序算法.common.Output;

/**
 * @Author dongboy
 * @what time    2022/12/19 12:22
 */
public class 归并排序 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 2, 1, 4, 5, 2, 6, 7, 8};
        method(nums1);
        Output.output(nums1);
        System.out.println();
        int[] nums2 = new int[]{3, 2, 1, 4, 5, 2, 6, 7, 8, 1, 3, 2, 1, 3, 4, 6, 7, 7, 857, 564};
        method(nums2);
        Output.output(nums2);
    }

    public static void method(int[] nums) {
        mergeSort(0, nums.length - 1, nums);
    }

    // 把数组分为两部分排序
    public static void mergeSort(int left, int right, int[] nums) {
        // 当left下标和right下标相遇的时候，也就是说只有一个元素的时候返回
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeSort(left, mid, nums);
        mergeSort(mid + 1, right, nums);
        // 进行合并
        merge(left, mid, right, nums);
    }

    public static void merge(int left, int mid, int right, int[] nums) {
        // 确定两个归并段的开始下标s1,和s2
        // 第一个归并段的开始
        int s1 = left;
        // 第二个归并段的开始
        int s2 = mid + 1;
        // 临时数组
        int[] temp = new int[right - left + 1];
        // index表示temp临时数组的下标
        int index = 0;
        // 把两个有序数组合并为一个有序数组
        while (s1 <= mid && s2 <= right) {
            if (nums[s1] <= nums[s2]) {
                temp[index] = nums[s1];
                s1++;
            } else {
                temp[index] = nums[s2];
                s2++;
            }
            index++;
        }
        // 排除s1对应的数组未排序完的情况
        while (s1 <= mid) {
            temp[index] = nums[s1];
            index++;
            s1++;
        }
        // 排除s2对应的数组未排序完的情况
        while (s2 <= right) {
            temp[index] = nums[s2];
            index++;
            s2++;
        }
        // 把排好序的temp数组，赋值给原来nums数组中对应的下标
        for (int i = left; i <= right; i++) {
            nums[i] = temp[i - left];
        }
    }

}
