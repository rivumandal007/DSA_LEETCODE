class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[] dirs = {0, 1, 0, -1, 0};
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    long sum = 0;
                    Deque<int[]> stack = new ArrayDeque<>();
                    stack.push(new int[]{i, j});
                    sum += grid[i][j];
                    grid[i][j] = 0; // mark visited

                    while (!stack.isEmpty()) {
                        int[] cur = stack.pop();
                        for (int d = 0; d < 4; d++) {
                            int r = cur[0] + dirs[d], c = cur[1] + dirs[d + 1];
                            if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] > 0) {
                                sum += grid[r][c];
                                grid[r][c] = 0;
                                stack.push(new int[]{r, c});
                            }
                        }
                    }
                    if (sum % k == 0) count++;
                }
            }
        }
        return count;
    }
}