package 排序算法;

import 排序算法.common.Output;

/**
 * @Author dongboy
 * @what time    2022/12/16 15:30
 */
public class 插入排序 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 2, 1, 4, 5, 2, 6, 7, 8};
        insertSort(nums1);
        Output.output(nums1);
        System.out.println();
    }

    public static void insertSort(int[] nums) {
        int n = nums.length;
        // i表示第几次插入，这里是指插入n - 1次，其中第一个元素由于只有一个，默认已经插入成功
        for (int i = 1; i < n; i++) {
            // 当前插入的开始位置
            int insertIndex = i;
            // 要用于插入的值
            int insertValue = nums[i];
            // 判断前面的元素是否有大于当前元素的，因为i之前的元素已经有序
            while (insertIndex > 0 && insertValue < nums[insertIndex - 1]) {
                // 相当于把当前数往后移动
                nums[insertIndex] = nums[insertIndex - 1];
                insertIndex--;
            }
            // 最终的insertIndex是要插入的位置
            nums[insertIndex] = insertValue;
        }
    }

}
