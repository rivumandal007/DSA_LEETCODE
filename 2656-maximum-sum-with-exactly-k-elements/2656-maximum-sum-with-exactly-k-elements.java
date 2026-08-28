class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        int i = 0; 
        int j = nums.length - 1;
        while(i <= j){
            max = Math.max(max,Math.max(nums[i], nums[j]));
            i++;
            j--;
        }
        int ans = 0;
        for(int n = max; n < max + k; n++){
            
            ans += n;
           
            System.out.println("ANS" + " " +ans);
            System.out.println(max);
        }
        return ans;
    }
}