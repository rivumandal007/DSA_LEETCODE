class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double [] ans = new double [nums.length / 2];
        int i = 0;
        int j = nums.length - 1;
        
        while(i < j){
          double avg = (double)(nums[i] + nums[j]) / 2;
          ans[i] = avg;
          System.out.println(avg);
          
          i++;
          j--;
        }
        double min = nums[nums.length - 1];
        for(int x = 0; x < ans.length; x++){
           if(min > ans[x]){
            min = ans[x];
           }
        }
        return min;
        
        
        
    }
}