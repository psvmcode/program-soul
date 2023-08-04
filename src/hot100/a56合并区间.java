package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author dongboy
 * @what time    2022/11/14 17:10
 */
public class a56合并区间 {

    // 迭代法
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int[] before = intervals[0]; // 记录上一个区间
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            // 看和上一个区间是否重合
            if (before[1] >= intervals[i][0]) {
                // 和上一个区间重合则合并区间
                before[0] = Math.min(before[0], intervals[i][0]);
                before[1] = Math.max(before[1], intervals[i][1]);
            } else {
                // 和上一个区间不重合则添加后，同时更新上一个区间
                list.add(Arrays.asList(before[0], before[1]));
                before = intervals[i];
            }
        }
        list.add(Arrays.asList(before[0], before[1]));
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = list.get(i).get(0);
            res[i][1] = list.get(i).get(1);
        }
        return res;
    }

}
