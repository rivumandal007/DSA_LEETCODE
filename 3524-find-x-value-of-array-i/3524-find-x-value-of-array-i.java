class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            long[] next = new long[k];

            int value = num % k;

            next[value]++;

            for (int j = 0; j < k; j++) {
                if (dp[j] > 0) {
                    int product = (j * value) % k;
                    next[product] += dp[j];
                }
            }

            for (int j = 0; j < k; j++) {
                ans[j] += next[j];
            }

            dp = next;
        }

        return ans;
    }
}