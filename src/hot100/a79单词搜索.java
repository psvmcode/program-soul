package hot100;

/**
 * @Author dongboy
 * @what time    2022/12/3 15:57
 */
public class a79单词搜索 {

    // 回溯法解题
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] target = new boolean[m][n]; // 默认为false，表示没走过
                    if (dfs(board, word, i, j, 0, target)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int x, int y, int index, boolean[][] target) {
        // 说明已经走完，成功的终止条件
        if (index >= word.length()) {
            return true;
        }
        // 终止条件:到达边界或者当前字符和下标对应的字符不一样时返回
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        // 当前已经走过了则返回，此路不通
        if (target[x][y]) {
            return false;
        }
        // 当前位置的字符不一样，此路不通
        if (board[x][y] != word.charAt(index)) {
            return false;
        }
        target[x][y] = true;
        // 然后看另外四个方向是否有合法的
        boolean one = dfs(board, word, x + 1, y, index + 1, target);
        boolean two = dfs(board, word, x - 1, y, index + 1, target);
        boolean three = dfs(board, word, x, y + 1, index + 1, target);
        boolean four = dfs(board, word, x, y - 1, index + 1, target);
        target[x][y] = false;
        return one || two || three || four;
    }

}
