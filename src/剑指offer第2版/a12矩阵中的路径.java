package 剑指offer第2版;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author dongboy
 * @what time    2023/2/4 17:24
 */
public class a12矩阵中的路径 {

    // dfs
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] target = new boolean[board.length][board[0].length];
                    if (dfs(board, word, i, j, target, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, boolean[][] target, int index) {
        // 判断是否走完
        if (index == word.length()) {
            return true;
        }
        // 越界的情况
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        // 如果当前已经走过
        if (target[i][j]) {
            return false;
        }
        // 判断当前字符位置是否一样
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        target[i][j] = true;
        boolean one = dfs(board, word, i + 1, j, target, index + 1);
        boolean two = dfs(board, word, i, j + 1, target, index + 1);
        boolean three = dfs(board, word, i - 1, j, target, index + 1);
        boolean four = dfs(board, word, i, j - 1, target, index + 1);
        target[i][j] = false;
        return one || two || three || four;
    }

}
