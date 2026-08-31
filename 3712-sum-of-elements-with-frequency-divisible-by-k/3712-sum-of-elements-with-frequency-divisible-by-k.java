class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = 0;
        int count = 1;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                count++;
            } else {
                if (count % k == 0) {
                    ans += nums[i] * count;
                }
                count = 1;
            }
        }

        return ans;
    }
}