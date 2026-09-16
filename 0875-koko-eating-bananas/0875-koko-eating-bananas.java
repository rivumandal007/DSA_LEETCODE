class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        int min = 1;
        for(int i = 0; i < piles.length; i++){
            if(piles[i] > max){
                max = piles[i];
            }
           
        }
        if(piles.length == h){
            return max;
        }
        
        int ans = max;
        while(min <= max){
            int mid = (max + min) / 2;
            int time = 0;
            for(int num : piles){
                time += num / mid + (num % mid != 0 ? 1 : 0);
            }
           
            if(time <= h && time > 0){
                ans = Math.min(ans, mid);
             
            }
            if(time > h){
                min = mid+1;
            }else{
                max = mid - 1;
            }
            
            
        }
        return ans;
        
    }
}