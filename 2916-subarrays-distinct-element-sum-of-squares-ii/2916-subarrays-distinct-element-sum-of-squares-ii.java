
class Solution {
    public int sumCounts(int[] nums) {
        int n = nums.length;
        int mod = 1000000007;

        long[] sum = new long[4 * n];
        long[] sq = new long[4 * n];
        long[] lazy = new long[4 * n];

        HashMap<Integer, Integer> last = new HashMap<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = last.getOrDefault(nums[i], -1);

            update(1, 0, n - 1, prev + 1, i, sum, sq, lazy, mod);

            ans = (ans + sq[1]) % mod;
            last.put(nums[i], i);
        }

        return (int) ans;
    }

    private void update(int node, int l, int r, int ql, int qr,
                        long[] sum, long[] sq, long[] lazy, int mod) {
        if (ql > r || qr < l) {
            return;
        }

        if (ql <= l && r <= qr) {
            long len = r - l + 1;
            sq[node] = (sq[node] + 2 * sum[node] + len) % mod;
            sum[node] = (sum[node] + len) % mod;
            lazy[node]++;
            return;
        }

        int mid = l + (r - l) / 2;
        push(node, l, r, sum, sq, lazy, mod);

        update(node * 2, l, mid, ql, qr, sum, sq, lazy, mod);
        update(node * 2 + 1, mid + 1, r, ql, qr, sum, sq, lazy, mod);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % mod;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % mod;
    }

    private void push(int node, int l, int r,
                      long[] sum, long[] sq, long[] lazy, int mod) {
        if (lazy[node] == 0 || l == r) {
            return;
        }

        int mid = l + (r - l) / 2;
        apply(node * 2, mid - l + 1, lazy[node], sum, sq, lazy, mod);
        apply(node * 2 + 1, r - mid, lazy[node], sum, sq, lazy, mod);

        lazy[node] = 0;
    }

    private void apply(int node, long len, long val,
                       long[] sum, long[] sq, long[] lazy, int mod) {
        sq[node] = (sq[node] + 2 * val % mod * sum[node] % mod
                    + val * val % mod * len % mod) % mod;

        sum[node] = (sum[node] + val * len) % mod;
        lazy[node] = (lazy[node] + val) % mod;
    }
}
