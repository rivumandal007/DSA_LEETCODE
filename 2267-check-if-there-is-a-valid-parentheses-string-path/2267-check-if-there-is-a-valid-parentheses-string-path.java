class Solution {
    int m, n;
    Boolean[][][] dp;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        dp = new Boolean[m][n][m + n];

        return solve(grid, 0, 0, 0);
    }

    public boolean solve(char[][] grid, int i, int j, int count) {

        if (grid[i][j] == '(') {
            count++;
        } else {
            count--;
        }

        if (count < 0) {
            return false;
        }

        if (i == m - 1 && j == n - 1) {
            return dp[i][j][count] = (count == 0);
        }

        if (dp[i][j][count] != null) {
            return dp[i][j][count];
        }

        boolean ans = false;

        if (i < m - 1) {
            ans = solve(grid, i + 1, j, count);
        }

        if (!ans && j < n - 1) {
            ans = solve(grid, i, j + 1, count);
        }

        return dp[i][j][count] = ans;
    }
}