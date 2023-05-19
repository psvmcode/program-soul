//package 剑指offer第2版;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author dongboy
// * @what time    2023/2/19 16:07
// */
//public class a38字符串的排列 {
//    public String[] permutation(String s) {
//        List<String> list = new ArrayList<>();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            dfs(i, s, sb, list);
//        }
//        String[] res = new String[list.size()];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = list.get(i);
//        }
//        return res;
//    }
//
//    public void dfs(int index, String s, StringBuilder sb, List<String> list) {
//        if (index == s.length()) {
//            list.add(sb.toString());
//            return;
//        }
//        sb.append(s.charAt(index));
//        dfs();
//    }
//}
