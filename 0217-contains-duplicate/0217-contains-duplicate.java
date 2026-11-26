class Solution {
    public boolean containsDuplicate(int[] nums) {
    
   Arrays.sort(nums);
   int pre = nums[0];

    for(int i = 1; i < nums.length; i++){
        if(pre == nums[i]){
            return true;
        }
        pre = nums[i];
    }
    return false;

        
    }
}