class Solution {
    int[] tree;
    int n;

    void upd(int i, int v) {
        for (i++; i <= n + 1; i += i & -i) tree[i] ^= v;
    }

    int qry(int i) {
        int r = 0;
        for (i++; i > 0; i -= i & -i) r ^= tree[i];
        return r;
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        tree = new int[n + 3];
        char[] ch = s.toCharArray();

        // adjacency list
        int[] head = new int[n], nxt = new int[2 * (n - 1)], to = new int[2 * (n - 1)];
        Arrays.fill(head, -1);
        int cnt = 0;
        for (int[] e : edges) {
            to[cnt] = e[1]; nxt[cnt] = head[e[0]]; head[e[0]] = cnt++;
            to[cnt] = e[0]; nxt[cnt] = head[e[1]]; head[e[1]] = cnt++;
        }

        int LOG = 1;
        while ((1 << LOG) < n) LOG++;
        int[][] up = new int[LOG + 1][n];
        int[] tin = new int[n], tout = new int[n], base = new int[n], depth = new int[n];

        // iterative DFS from root 0
        int[] stack = new int[n], it = new int[n];
        int sp = 0, timer = 0;
        stack[sp++] = 0;
        up[0][0] = 0;
        base[0] = 1 << (ch[0] - 'a');
        tin[0] = timer++;
        System.arraycopy(head, 0, it, 0, n);
        while (sp > 0) {
            int u = stack[sp - 1];
            if (it[u] != -1) {
                int e = it[u];
                it[u] = nxt[e];
                int v = to[e];
                if (v == up[0][u]) continue; // skip parent
                up[0][v] = u;
                depth[v] = depth[u] + 1;
                base[v] = base[u] ^ (1 << (ch[v] - 'a'));
                tin[v] = timer++;
                stack[sp++] = v;
            } else {
                tout[u] = timer - 1;
                sp--;
            }
        }

        // binary lifting table
        for (int k = 1; k <= LOG; k++)
            for (int v = 0; v < n; v++)
                up[k][v] = up[k - 1][up[k - 1][v]];

        List<Boolean> res = new ArrayList<>();
        for (String q : queries) {
            String[] p = q.split(" ");
            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                char c = p[2].charAt(0);
                int delta = (1 << (ch[u] - 'a')) ^ (1 << (c - 'a'));
                if (delta != 0) {
                    upd(tin[u], delta);        // range XOR on u's subtree
                    upd(tout[u] + 1, delta);
                    ch[u] = c;
                }
            } else {
                int u = Integer.parseInt(p[1]), v = Integer.parseInt(p[2]);

                // LCA
                int a = u, b = v;
                if (depth[a] < depth[b]) { int t = a; a = b; b = t; }
                int diff = depth[a] - depth[b];
                for (int k = 0; k <= LOG; k++)
                    if ((diff >> k & 1) == 1) a = up[k][a];
                if (a != b) {
                    for (int k = LOG; k >= 0; k--) {
                        if (up[k][a] != up[k][b]) {
                            a = up[k][a];
                            b = up[k][b];
                        }
                    }
                    a = up[0][a];
                }
                int lca = a;

                int pu = base[u] ^ qry(tin[u]);
                int pv = base[v] ^ qry(tin[v]);
                int mask = pu ^ pv ^ (1 << (ch[lca] - 'a'));
                res.add((mask & (mask - 1)) == 0); // at most one odd-count letter
            }
        }
        return res;
    }
}