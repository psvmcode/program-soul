package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author dongboy
 * @what time    2022/11/2 20:13
 */
public class a39组合总和 {

    List<List<Integer>> res;
    List<Integer> path;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(candidates, target, 0);
        return res;
    }

    // 参数:数组+目标数+当前开始下标
    public void backtracking(int[] candidates, int target, int index) {
        // 终止条件
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 每次可以分为选择当前数和不选择当前数两种情况
        // 不选择当前数
        backtracking(candidates, target, index + 1);
        // 选择当前数，前提是当前数不大于target
        if (candidates[index] > target) {
            return;
        }
        if (target - candidates[index] >= 0) {
            path.add(candidates[index]);
            backtracking(candidates, target - candidates[index], index);
            path.remove(path.size() - 1);
        }
    }

//    List<List<Integer>> res;
//    List<Integer> path;
//    int sum;
//
//    // 回溯解法(排序+剪枝操作)
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        res = new ArrayList<>();
//        path = new ArrayList<>();
//        Arrays.sort(candidates);
//        backtracking(0, candidates, target);
//        return res;
//    }
//
//    public void backtracking(int index, int[] candidates, int target) {
//        if (sum >= target) {
//            if (sum == target) {
//                res.add(new ArrayList<>(path));
//            }
//            return;
//        }
//        for (int i = index; i < candidates.length; i++) {
//            if (candidates[i] > target) {
//                break;
//            }
//            path.add(candidates[i]);
//            sum += candidates[i];
//            backtracking(i, candidates, target);
//            path.remove(path.size() - 1);
//            sum -= candidates[i];
//        }
//    }

}
