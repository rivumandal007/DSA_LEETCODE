class Solution {
    public int maximumGap(int[] nums) {
        
        if(nums.length <= 1){
            return 0;
        }
        Arrays.sort(nums);
        int max_diff = 0; 
        for(int i = 0; i < nums.length - 1; i++){
            int diff = nums[i + 1] - nums[i];
            max_diff = Math.max(max_diff, diff);
        }
        return max_diff;
    }
}