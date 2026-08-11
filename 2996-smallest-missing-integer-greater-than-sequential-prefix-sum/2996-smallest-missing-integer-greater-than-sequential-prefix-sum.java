class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        ArrayList <Integer> li = new ArrayList<>();
        int max = nums[0];
        li.add(nums[0]);
        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i - 1] + 1 ){
                li.add(nums[i]);

            }else{
                break;
            }
            
        }
        
        int sum = 0;
        for(int i = 0; i < li.size(); i++){
            sum = sum + li.get(i);
        }
        int ans = sum;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++){
            if(ans == nums[i]){
                ans += 1;
            }
        }
        return ans;
        
        
    }
}