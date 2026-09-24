class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int [] ans = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {
            int left = nums[i] * i - leftSum;
            int right = (sum - leftSum - nums[i]) - nums[i] * (nums.length - i - 1);

            ans[i] = left + right;

            leftSum += nums[i];
        }
        return ans;
    }
}