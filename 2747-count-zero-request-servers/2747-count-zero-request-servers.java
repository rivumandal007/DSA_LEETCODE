class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int k = queries.length;
        Integer[] order = new Integer[k];
        for (int i = 0; i < k; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> Integer.compare(queries[a], queries[b]));

        int[] cnt = new int[n + 1];
        int[] res = new int[k];
        int active = 0, l = 0, r = 0, m = logs.length;

        for (int i : order) {
            int q = queries[i];

            // extend window: add logs with time <= q
            while (r < m && logs[r][1] <= q) {
                if (++cnt[logs[r][0]] == 1) active++;
                r++;
            }

            // shrink window: remove logs with time < q - x
            while (l < r && logs[l][1] < q - x) {
                if (--cnt[logs[l][0]] == 0) active--;
                l++;
            }

            res[i] = n - active;
        }
        return res;
    }
}
