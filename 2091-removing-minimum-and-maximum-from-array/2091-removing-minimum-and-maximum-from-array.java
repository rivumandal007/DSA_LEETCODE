class Solution {
    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIdx = 0;
        int maxIdx = 0;
        for(int i = 0; i < nums.length; i++){
            if(max < nums[i]){
                maxIdx = i;
                max = nums[i];
            }
            if(min > nums[i]){
                minIdx = i;
                min = nums[i];
            }
        }
        if(minIdx > maxIdx){
            int temp = minIdx;
            minIdx = maxIdx;
            maxIdx = temp;
        }

        int left = maxIdx + 1;
        int right = nums.length - minIdx;
        int both = minIdx + 1 + nums.length - maxIdx;

        return Math.min(left, Math.min(right, both));
        
    }
}