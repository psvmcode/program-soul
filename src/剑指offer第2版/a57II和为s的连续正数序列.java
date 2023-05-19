package 剑指offer第2版;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author dongboy
 * @what time    2023/3/2 22:05
 */
public class a57II和为s的连续正数序列 {

    // 暴力
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= target; i++) {
            for (int j = i + 1; j <= target; j++) {
                int cur = (j + i) * (j - i + 1) / 2;
                if (cur >= target) {
                    if (cur == target) {
                        int[] temp = new int[j - i + 1];
                        int index = 0;
                        for (int k = i; k <= j; k++) {
                            temp[index++] = k;
                        }
                        list.add(temp);
                    }
                    break;
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

}
