class Solution {
    public int totalNumbers(int[] digits) {
        HashMap<Integer, Integer> map = new HashMap <>();
        int ans = 0;
        for(int i = 0; i < digits.length; i++){
            if(digits[i] == 0){
                continue;
            }
           
            for(int j = 0; j < digits.length; j++){
                if(i==j){
                    continue;
                }
               
                for(int k = 0; k < digits.length; k++){
                    if(i == k || j == k){
                        continue;
                    }
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];

                    if (num % 2 == 0 && !map.containsKey(num)) {
                        ans++;
                        map.put(num, 1);
                    }
                }
            }
            
        }
        return ans;
    }
}