class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int best = Integer.MAX_VALUE;

        // Case 1: rotation of sorted
        boolean ok1 = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] != (nums[0] + i) % n) { ok1 = false; break; }
        }
        if (ok1) {
            int s = nums[0];
            int cost = (s == 0) ? 0 : Math.min(n - s, s + 2);
            best = Math.min(best, cost);
        }

        // Case 2: rotation of reversed sorted
        boolean ok2 = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] != (((nums[0] - i) % n) + n) % n) { ok2 = false; break; }
        }
        if (ok2) {
            int s = nums[n - 1];
            int cost = (s == 0) ? 1 : 1 + Math.min(s, n - s);
            best = Math.min(best, cost);
        }

        return best == Integer.MAX_VALUE ? -1 : best;
    }
}