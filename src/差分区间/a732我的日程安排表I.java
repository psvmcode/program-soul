package 差分区间;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author dongboy
 * @what time    2023/1/15 13:15
 */
public class a732我的日程安排表I {

}

//class MyCalendar {
//
//    List<int[]> list;
//
//    public MyCalendar() {
//        list = new ArrayList<>();
//    }
//
//    public boolean book(int startTime, int endTime) {
//        for (int i = 0; i < list.size(); i++) {
//            boolean flag = startTime >= list.get(i)[1] || endTime <= list.get(i)[0];
//            if (!flag) {
//                return false;
//            }
//        }
//        list.add(new int[]{startTime, endTime});
//        return true;
//    }
//}

class MyCalendar {

    TreeSet<int[]> treeSet;

    public MyCalendar() {
        // 升序维护
        treeSet = new TreeSet<>((a, b) -> a[0] - b[0]);
    }

    public boolean book(int start, int end) {
        if (treeSet.isEmpty()) {
            treeSet.add(new int[]{start, end});
            return true;
        }
        int[] temp = new int[]{end, 0};
        // 第一个下标正好大于end的数组
        int[] after = treeSet.ceiling(temp);
        // after的前一个数组
        int[] before = (after == null ? treeSet.last() : treeSet.lower(after));
        if (after == treeSet.first() || treeSet.lower(temp)[1] < start) {
            treeSet.add(new int[]{start, end});
            return true;
        }
        return false;
    }

}
