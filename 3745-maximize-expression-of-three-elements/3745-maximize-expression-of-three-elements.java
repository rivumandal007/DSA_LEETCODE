class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int max1 = Integer.MIN_VALUE;

        int max2 = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int n : nums){
            if(n > max1){
                max2 = max1;
                max1 = n;
                
            }else{
                if(max2 < n){
                    max2 = n;
                }
            }
            if(n < min){
                min = n;
            }
        }
        System.out.println(max1 + " " + max2 + " " + min);
        return (max1 + max2 - min);
        
    }
}