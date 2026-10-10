

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        long[] diff = new long[n];
        long sum = 0;
        long max = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            sum += diff[i];
            max = Math.max(max, diff[i]);
        }

        if (sum <= k) {
            return 0;
        }

        long left = 0, right = max;

        while (left < right) {
            long mid = left + (right - left) / 2;
            long need = 0;

            for (long d : diff) {
                if (d > mid) {
                    need += d - mid;
                }
            }

            if (need <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        long level = left;
        long ans = 0;
        long used = 0;

        for (long d : diff) {
            if (d > level) {
                used += d - level;
                d = level;
            }
            ans += d * d;
        }

        long remaining = k - used;

        for (int i = 0; i < n && remaining > 0; i++) {
            if (diff[i] >= level && diff[i] > 0) {
                ans -= level * level;
                ans += (level - 1) * (level - 1);
                remaining--;
                diff[i] = level - 1;
            }
        }

        return ans;
    }
}
