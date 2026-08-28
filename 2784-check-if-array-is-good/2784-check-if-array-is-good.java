class Solution {
    public boolean isGood(int[] nums) {
        HashMap <Integer, Integer> map = new HashMap <> ();
        int max = 0;
        int i =0;
        int j = nums.length - 1;
        while(i <= j){
            max = Math.max(max, Math.max(nums[i], nums[j]));
            if(i == j){
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                break;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            i++;
            j--;
        }
        

        return map.get(max) == 2 && nums.length == max + 1 && map.size() == max ? true : false;
        
    }
}