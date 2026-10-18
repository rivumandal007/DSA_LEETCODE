
class Solution {
    static final int MOD = 1000000007;
    long[][] comb;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        comb = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            comb[i][0] = comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        return (int) ((solve(nums) - 1 + MOD) % MOD);
    }

    private long solve(int[] nums) {
        int n = nums.length;

        if (n <= 2) {
            return 1;
        }

        int root = nums[0];
        int leftCount = 0;
        int rightCount = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 1; i < n; i++) {
            if (nums[i] < root) {
                left[leftCount++] = nums[i];
            } else {
                right[rightCount++] = nums[i];
            }
        }

        left = java.util.Arrays.copyOf(left, leftCount);
        right = java.util.Arrays.copyOf(right, rightCount);

        long ways = comb[n - 1][leftCount];
        ways = (ways * solve(left)) % MOD;
        ways = (ways * solve(right)) % MOD;

        return ways;
    }
}
