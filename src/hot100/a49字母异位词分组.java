package hot100;

import java.util.*;

/**
 * @Author dongboy
 * @what time    2022/11/6 21:04
 */
public class a49字母异位词分组 {
    public static void main(String[] args) {

    }

    // HashMap解法，每次将字符串根据字典序排序后，放进哈希键值对中，根据字典序排序后是唯一的key
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String data : strs) {
            char[] chars = data.toCharArray();
            Arrays.sort(chars);
            String cur = new String(chars);
            if (!map.containsKey(cur)) {
                map.put(cur, new ArrayList<>());
            }
            map.get(cur).add(data);
        }
        List<List<String>> res = new ArrayList<>();
        for (String data : map.keySet()) {
            res.add(map.get(data));
        }
        return res;
    }

}
