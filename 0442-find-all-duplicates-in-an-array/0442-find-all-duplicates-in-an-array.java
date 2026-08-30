class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList <Integer> li = new ArrayList <> ();
        int n = nums.length;
        for(int num : nums){
            int idx = n - Math.abs(num);
            if(nums[idx] < 0){
                li.add(Math.abs(num));
            } else{
                nums[idx] = - nums[idx];
            }
        }
        return li;

    }
}