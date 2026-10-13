class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] sq = new long[n];
        for (int i = 0; i < n; i++) {
            sq[i] = (long) nums[i] * nums[i];
        }
        Arrays.sort(sq);

        int negCount = n / 2;          // odd positions
        long result = 0;
        for (int i = 0; i < n; i++) {
            if (i < negCount) {
                result -= sq[i];       // smallest squares subtracted
            } else {
                result += sq[i];       // largest squares added
            }
        }
        return result;
    }
}