class Solution {
    public int minMoves(String[] classroom, int energy) {
        int n = classroom.length;
        int m = classroom[0].length();

        int sr = 0, sc = 0;
        List<int[]> trash = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = classroom[i].charAt(j);

                if (c == 'S') {
                    sr = i;
                    sc = j;
                } else if (c == 'L') {
                    trash.add(new int[]{i, j});
                }
            }
        }

        int total = trash.size();

        if (total == 0) {
            return 0;
        }

        int fullMask = (1 << total) - 1;

        int[][] trashId = new int[n][m];
        for (int[] row : trashId) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < total; i++) {
            trashId[trash.get(i)[0]][trash.get(i)[1]] = i;
        }

        boolean[][][][] visited =
                new boolean[n][m][energy + 1][1 << total];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{sr, sc, energy, 0});
        visited[sr][sc][energy][0] = true;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] cur = q.poll();

                int r = cur[0];
                int c = cur[1];
                int e = cur[2];
                int mask = cur[3];

                if (mask == fullMask) {
                    return moves;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                        continue;
                    }

                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    if (e == 0) {
                        continue;
                    }

                    int ne = e - 1;
                    int nmask = mask;

                    if (classroom[nr].charAt(nc) == 'L') {
                        nmask |= (1 << trashId[nr][nc]);
                    }

                    if (classroom[nr].charAt(nc) == 'R') {
                        ne = energy;
                    }

                    if (!visited[nr][nc][ne][nmask]) {
                        visited[nr][nc][ne][nmask] = true;
                        q.offer(new int[]{nr, nc, ne, nmask});
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}