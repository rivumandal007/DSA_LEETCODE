class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 0; 
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i+1]){
                count2++;
            }else{
                ans = Math.max(ans, count2);
                count2 = 0;
            }
            if(nums[i] < nums[i+1]){
                count1++;
            }else{
                ans = Math.max(ans, count1);
                count1 = 0;
            }
        }
        ans = Math.max(Math.max(count1, count2), ans);
        return ans + 1;
        
    }
}