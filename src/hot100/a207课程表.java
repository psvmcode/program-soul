package hot100;

import 集合源码.ArrayList;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 * @Author dongboy
 * @what time    2022/12/14 20:18
 */
public class a207课程表 {
    public static void main(String[] args) {

    }

//    // 构造有向图，判断有向图中是否有环
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        List<Integer>[] lists = new List[numCourses];
//        for (int i = 0; i < numCourses; i++) {
//            lists[i] = new ArrayList<>();
//        }
//        for (int i = 0; i < prerequisites.length; i++) {
//            int one = prerequisites[i][0];
//            int two = prerequisites[i][1];
//            lists[two].add(one);
//        }
//        for (int i = 0; i < numCourses; i++) {
//            Queue<Integer> queue = new ArrayDeque<>();
//            queue.offer(i);
//            boolean[] flag = new boolean[numCourses];
//            while (!queue.isEmpty()) {
//                int cur = queue.poll();
//                // 如果当前元素没有放进过队列
//                if (!flag[cur]) {
//                    for (int j = 0; j < lists[cur].size(); j++) {
//                        int temp = lists[cur].get(j);
//                        // 出现有走过的，说明出现了环
//                        if (temp == i) {
//                            return false;
//                        }
//                        queue.offer(temp);
//                    }
//                    flag[cur] = true;
//                }
//            }
//        }
//        return true;
//    }

    // 构造拓扑排序
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 计算每个节点的入度
        int[] count = new int[numCourses];
        List<Integer>[] lists = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int one = prerequisites[i][0];
            int two = prerequisites[i][1];
            lists[two].add(one);
            // 记录每个节点的入度
            count[one]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            // 先把所有入度为0的节点加进队列
            if (count[i] == 0) {
                queue.offer(i);
            }
        }
        // 最终入度为0的节点
        int visit = 0;
        while (!queue.isEmpty()) {
            visit++;
            int cur = queue.poll();
            for (int i = 0; i < lists[cur].size(); i++) {
                // 模拟删除这条指针，代表当前节点的入度减一
                count[lists[cur].get(i)]--;
                // 只有当前节点的入度为0时才加进队列
                if (count[lists[cur].get(i)] == 0) {
                    queue.offer(lists[cur].get(i));
                }
            }
        }
        return visit == numCourses;
    }

}
