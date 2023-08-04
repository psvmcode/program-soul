package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author dongboy
 * @what time    2023/1/18 22:15
 */
public class a406根据身高重建队列 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            // 身高一样就按照排名升序，否则按照身高降序
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        int[][] res = new int[people.length][2];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            // 在指定位置插入元素
            list.add(people[i][1], people[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
