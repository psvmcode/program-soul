package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author dongboy
 * @what time    2022/12/3 10:54
 */
public class a78子集 {
    public static void main(String[] args) {

    }

//    List<Integer> path;
//    List<List<Integer>> res;
//
//    // 回溯
//    public List<List<Integer>> subsets(int[] nums) {
//        path = new ArrayList<>();
//        res = new ArrayList<>();
//        for (int i = 0; i <= nums.length; i++) {
//            dfs(nums, i, 0);
//        }
//        return res;
//    }
//
//    public void dfs(int[] nums, int len, int index) {
//        if (path.size() == len) {
//            res.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = index; i < nums.length; i++) {
//            path.add(nums[i]);
//            dfs(nums, len, i + 1);
//            path.remove(path.size() - 1);
//        }
//    }

    // 迭代解法
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        // 每一次遍历，把当前遍历的元素，和res中的所有元素结合后再加进去
        // null,1,2,12,3,13,23,123
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> data : res) {
                List<Integer> cur = new ArrayList<>(data);
                cur.add(nums[i]);
                temp.add(cur);
            }
            res.addAll(temp);
        }
        return res;
    }

}
