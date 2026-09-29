class Solution {
    private static int[][][] dp = new int[101][101][201];
    private int m, n;

    private boolean recur(char[][] grid, int i, int j, int cnt) {
        if (i >= m || j >= n)
            return false;

        cnt += grid[i][j] == '(' ? 1 : -1;

        if (cnt < 0)
            return false;

        if (dp[i][j][cnt] != -1)
            return dp[i][j][cnt] == 1;

        if (i == m - 1 && j == n - 1)
            return (dp[i][j][cnt] = cnt == 0 ? 1 : 0) == 1;

        boolean ans = recur(grid, i + 1, j, cnt) ||
                      recur(grid, i, j + 1, cnt);

        dp[i][j][cnt] = ans ? 1 : 0;
        return ans;
    }

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if ((m + n - 1) % 2 == 1)
            return false;

        for (int i = 0; i < 101; i++)
            for (int j = 0; j < 101; j++)
                java.util.Arrays.fill(dp[i][j], -1);

        return recur(grid, 0, 0, 0);
    }
}