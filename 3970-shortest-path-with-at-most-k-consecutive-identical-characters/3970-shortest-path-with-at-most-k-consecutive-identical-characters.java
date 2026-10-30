class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        if (k < 1) return -1;          // node 0 alone already forms a run of 1
        k = Math.min(k, n);            // a run can't be longer than n

        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) graph[e[0]].add(new int[]{e[1], e[2]});

        long INF = Long.MAX_VALUE / 4;
        long[][] dist = new long[n][k + 1];
        for (long[] row : dist) Arrays.fill(row, INF);
        dist[0][1] = 0;

        // {cost, node, run}
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 0, 1});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1], run = (int) cur[2];

            if (d > dist[u][run]) continue;      // stale entry
            if (u == n - 1) return (int) d;      // first pop of target is optimal

            for (int[] edge : graph[u]) {
                int v = edge[0], w = edge[1];
                int newRun = labels.charAt(v) == labels.charAt(u) ? run + 1 : 1;
                if (newRun > k) continue;

                long nd = d + w;
                if (nd < dist[v][newRun]) {
                    dist[v][newRun] = nd;
                    pq.offer(new long[]{nd, v, newRun});
                }
            }
        }
        return -1;
    }
}