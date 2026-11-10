class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List <Integer> li = new ArrayList <>();
        Arrays.sort(nums);
        int i = 0; int j = nums.length - 1;
        int sum1 = 0;
        int sum2 = 0;
        while(i <= j){
            if(sum1 + nums[i] >= sum2){
                sum2 += nums[j];
                li.add(nums[j]);
                j--;
            }else{
                sum1 += nums[i];
                i++;
            }
        }
       
        return li;
    }
}