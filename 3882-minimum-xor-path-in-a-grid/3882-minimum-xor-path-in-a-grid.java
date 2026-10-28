class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int max = 0;
        for (int[] row : grid)
            for (int v : row) max = Math.max(max, v);
        int B = 1;
        while (B <= max) B <<= 1; // all XORs stay below B

        boolean[][] prev = new boolean[n][B];
        boolean[][] cur = new boolean[n][B];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[] now = cur[j];
                java.util.Arrays.fill(now, false);
                int v = grid[i][j];

                if (i == 0 && j == 0) {
                    now[v] = true;
                    continue;
                }
                if (i > 0) {
                    boolean[] top = prev[j];
                    for (int x = 0; x < B; x++)
                        if (top[x]) now[x ^ v] = true;
                }
                if (j > 0) {
                    boolean[] left = cur[j - 1];
                    for (int x = 0; x < B; x++)
                        if (left[x]) now[x ^ v] = true;
                }
            }
            boolean[][] tmp = prev;
            prev = cur;
            cur = tmp;
        }

        boolean[] last = prev[n - 1];
        for (int x = 0; x < B; x++)
            if (last[x]) return x;
        return -1;
    }
}