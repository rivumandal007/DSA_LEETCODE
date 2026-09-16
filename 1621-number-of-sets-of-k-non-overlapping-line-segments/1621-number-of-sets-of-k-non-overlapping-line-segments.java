class Solution {
    public int numberOfSets(int n, int k) {
        long MOD = 1000000007;

        int N = n + k - 1;
        int R = 2 * k;

        long[] fact = new long[N + 1];
        fact[0] = 1;

        for (int i = 1; i <= N; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        long a = fact[N];
        long b = power(fact[R], MOD - 2, MOD);
        long c = power(fact[N - R], MOD - 2, MOD);

        return (int)(a * b % MOD * c % MOD);
    }

    public long power(long a, long b, long MOD) {
        long ans = 1;

        while (b > 0) {
            if (b % 2 == 1) {
                ans = ans * a % MOD;
            }

            a = a * a % MOD;
            b /= 2;
        }

        return ans;
    }
}