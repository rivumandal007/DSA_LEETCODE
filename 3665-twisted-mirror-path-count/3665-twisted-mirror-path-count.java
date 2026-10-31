class Solution {
    public int uniquePaths(int[][] grid) {
        final int MOD = 1_000_000_007;
        int m = grid.length, n = grid[0].length;
        if (m == 1 && n == 1) return 1;

        long[][] R = new long[m + 1][n + 1];
        long[][] D = new long[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == m - 1 && j == n - 1) break;

                long r = R[i][j], d = D[i][j];

                if (grid[i][j] == 0) {
                    long total = r + d + ((i == 0 && j == 0) ? 1 : 0);
                    total %= MOD;
                    R[i][j + 1] = (R[i][j + 1] + total) % MOD;   // continue right
                    D[i + 1][j] = (D[i + 1][j] + total) % MOD;   // continue down
                } else {
                    D[i + 1][j] = (D[i + 1][j] + r) % MOD;       // entered moving right -> turn down
                    R[i][j + 1] = (R[i][j + 1] + d) % MOD;       // entered moving down -> turn right
                }
            }
        }
        return (int) ((R[m - 1][n - 1] + D[m - 1][n - 1]) % MOD);
    }
}