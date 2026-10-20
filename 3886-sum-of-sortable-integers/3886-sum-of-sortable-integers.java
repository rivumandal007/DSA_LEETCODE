class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;
            int prevMax = Integer.MIN_VALUE;

            for (int i = 0; i < n && valid; i += k) {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                int desc = 0;

                for (int j = i; j < i + k; j++) {
                    min = Math.min(min, nums[j]);
                    max = Math.max(max, nums[j]);

                    if (j > i && nums[j - 1] > nums[j]) {
                        desc++;
                    }
                }

                if (k > 1 && nums[i + k - 1] > nums[i]) {
                    desc++;
                }

                if ((desc != 1 && min != max) || min < prevMax) {
                    valid = false;
                    break;
                }

                prevMax = max;
            }

            if (valid) {
                ans += k;
            }
        }

        return ans;
    }
}