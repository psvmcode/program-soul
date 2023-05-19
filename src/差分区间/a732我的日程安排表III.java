package 差分区间;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author dongboy
 * @what time    2023/1/15 13:15
 */
public class a732我的日程安排表III {
}

class MyCalendarThree {

    TreeMap<Integer, Integer> map;

    public MyCalendarThree() {
        map = new TreeMap<>((a, b) -> a - b);
    }

    public int book(int startTime, int endTime) {
        int res = 0;
        int max = 0;
        map.put(startTime, map.getOrDefault(startTime, 0) + 1);
        map.put(endTime, map.getOrDefault(endTime, 0) - 1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max += entry.getValue();
            res = Math.max(res, max);
        }
        return res;
    }
}
