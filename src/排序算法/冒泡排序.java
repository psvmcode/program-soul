package 排序算法;

import 排序算法.common.Output;

/**
 * @Author dongboy
 * @what time    2022/12/16 11:16
 */
public class 冒泡排序 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 2, 1, 4, 5, 2, 6, 7, 8};
        bubbleSort1(nums1);
        Output.output(nums1);

        System.out.println();

        int[] nums2 = new int[]{3, 2, 1, 4, 5, 2, 6, 7, 8};
        bubbleSort2(nums2);
        Output.output(nums2);
    }

    // 传统的冒泡排序
    public static void bubbleSort1(int[] nums) {
        int n = nums.length;
        // 升序排序中，每一次冒泡都把最后一个数确定了，即每一轮最后多出一个数不用比较
        // i表示从后往前已经排好顺序的数字个数
        for (int i = 0; i < n - 1; i++) {
            // j是实际进行冒泡的下标操作数
            for (int j = 0; j < n - i - 1; j++) {
                // 如果进入当前判断说明数组无序，否则数组已经有序(优化点)
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    // 在已经有序的情况下，冒泡排序仍然会比较相邻元素，因此需要

    // 冒泡排序优化
    public static void bubbleSort2(int[] nums) {
        int n = nums.length;
        // 定义一个标准，判断数组是否已经有序
        boolean flag = true;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    // 一旦进入判断内，说明无序，说明此时无序
                    flag = false;
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            if (flag) {
                break;
            } else {
                flag = true;
            }
        }
    }

}
