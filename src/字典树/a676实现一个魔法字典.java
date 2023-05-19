package 字典树;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @Author dongboy
 * @what time    2022/12/12 12:47
 */
public class a676实现一个魔法字典 {
    public static void main(String[] args) {

    }
}

// 集合解题
class MagicDictionary {

    List<String> list;

    public MagicDictionary() {
        list = new ArrayList<>();
    }

    public void buildDict(String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            list.add(dictionary[i]);
        }
        Collections.sort(list, (a, b) -> a.length() - b.length());
    }

    public boolean search(String searchWord) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > searchWord.length()) {
                break;
            }
            if (list.get(i).length() == searchWord.length()) {
                int count = 0;
                for (int j = 0; j < searchWord.length(); j++) {
                    if (list.get(i).charAt(j) != searchWord.charAt(j)) {
                        count++;
                        if (count > 1) {
                            break;
                        }
                    }
                }
                if (count == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

// 字典树解题
//class MagicDictionary {
//
//    MagicDictionary[] children;
//    boolean isWord;
//
//    public MagicDictionary() {
//        children = new MagicDictionary[26];
//        isWord = false;
//    }
//
//    public void buildDict(String[] dictionary) {
//        for (int i = 0; i < dictionary.length; i++) {
//            MagicDictionary cur = this;
//            for (int j = 0; j < dictionary[i].length(); j++) {
//                if (cur.children[dictionary[i].charAt(j) - 'a'] == null) {
//                    cur.children[dictionary[i].charAt(j) - 'a'] = new MagicDictionary();
//                }
//                cur = cur.children[dictionary[i].charAt(j) - 'a'];
//            }
//            cur.isWord = true;
//        }
//    }
//
//    public boolean search(String searchWord) {
//        return dfs(searchWord, this, 0, false);
//    }
//
//    public boolean dfs(String searchWord, MagicDictionary cur, int index, boolean modify) {
//        // 终止条件
//        if (index == searchWord.length()) {
//            // 必须替换了一次
//            return modify && cur.isWord;
//        }
//        // 当前下标对应的字符存在
//        if (cur.children[searchWord.charAt(index) - 'a'] != null) {
//            if (dfs(searchWord, cur.children[searchWord.charAt(index) - 'a'], index + 1, modify)) {
//                return true;
//            }
//        }
//        if (!modify) {
//            for (int i = 0; i < 26; i++) {
//                if (i != (searchWord.charAt(index) - 'a') && cur.children[i] != null) {
//                    if (dfs(searchWord, cur.children[i], index + 1, true)) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
//}
