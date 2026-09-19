class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for(int i = 1; i <= n; i += 2){
            for(int j = 0; j < n  ; j++){
                int k = j;
                while(k < j+i && j+i <= n){
                    sum += arr[k];
                    k++;
                
                }
            }
        }
        return sum;
    }
}