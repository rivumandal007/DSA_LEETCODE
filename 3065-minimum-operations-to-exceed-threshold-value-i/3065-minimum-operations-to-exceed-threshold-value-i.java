class Solution {
    public int minOperations(int[] nums, int k) {
        int count = 0;
        for(int num : nums){
            if(k > num){
                count++;
            }
        }
        return count;
        
    }
}