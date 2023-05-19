package hot100;

/**
 * @Author dongboy
 * @what time    2022/12/13 14:46
 */
public class a200岛屿数量 {
    public static void main(String[] args) {

    }

    // 回溯
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果是岛屿上的点并且没有被访问过，就dfs一下
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int x, int y) {
        // 终止条件
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
            return;
        }
        // 把当前陆地链接的所有合法陆地都设为0
        grid[x][y] = '0';
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }

}
