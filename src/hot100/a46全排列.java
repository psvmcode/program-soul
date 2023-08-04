package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author dongboy
 * @what time    2022/11/5 20:27
 */
public class a46全排列 {

    // 回溯解法
    List<List<Integer>> res;
    List<Integer> path;
    boolean[] flag;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        flag = new boolean[nums.length]; // 标记是否填写
        backtracking(nums);
        return res;
    }

    public void backtracking(int[] nums) {
        // 终止条件
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }
        // 回溯体
        for (int i = 0; i < nums.length; i++) {
            // 保持不能加入重复元素
            if (flag[i]) {
                continue;
            }
            // 确保不是重复元素后加入
            path.add(nums[i]);
            flag[i] = true;
            // 回溯加入下一个
            backtracking(nums);
            // 删除当前
            flag[i] = false;
            path.remove(path.size() - 1);
        }
    }

}
