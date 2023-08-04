package 字典树;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @Author dongboy
 * @what time    2022/12/12 11:41
 */
public class a648单词替换 {

    // 暴力解法(回家等通知)
    public String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort(dictionary, (a, b) -> a.length() - b.length());
        StringBuilder sb = new StringBuilder();
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            boolean flag = true;
            for (int j = 0; j < dictionary.size(); j++) {
                if (strings[i].startsWith(dictionary.get(j))) {
                    sb.append(dictionary.get(j));
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append(strings[i]);
            }
            if (i != strings.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

//    // 构造字典树解题
//    public String replaceWords(List<String> dictionary, String sentence) {
//        Trie root = new Trie();
//        for (int i = 0; i < dictionary.size(); i++) {
//            Trie cur = root;
//            for (int j = 0; j < dictionary.get(i).length(); j++) {
//                if (cur.children[dictionary.get(i).charAt(j) - 'a'] == null) {
//                    cur.children[dictionary.get(i).charAt(j) - 'a'] = new Trie();
//                }
//                cur = cur.children[dictionary.get(i).charAt(j) - 'a'];
//            }
//            cur.isWord = true;
//        }
//        String[] strings = sentence.split(" ");
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < strings.length; i++) {
//            Trie cur = root;
//            // 标志要不要替代原来的
//            boolean flag = false;
//            for (int j = 0; j < strings[i].length(); j++) {
//                if (cur.children[strings[i].charAt(j) - 'a'] == null) {
//                    break;
//                } else {
//                    cur = cur.children[strings[i].charAt(j) - 'a'];
//                    if (cur.isWord) {
//                        flag = true;
//                        sb.append(strings[i].substring(0, j + 1));
//                        break;
//                    }
//                }
//            }
//            if (!flag) {
//                sb.append(strings[i]);
//            }
//            if (i != strings.length - 1) {
//                sb.append(" ");
//            }
//        }
//        return sb.toString();
//    }
//
//    public class Trie {
//        Trie[] children = new Trie[26];
//        boolean isWord = false;
//    }

}
