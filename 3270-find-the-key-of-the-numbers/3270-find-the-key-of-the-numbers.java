class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int ans = 0;
        int count = 0;
        while(num1 != 0 || num2 != 0 || num3 != 0){
            int a = num1 % 10;
            num1 /= 10;
            int b = num2 % 10;
            num2 /= 10;
            int c = num3 % 10;
            num3 /= 10;
            int min = Math.min(a, Math.min(b, c));
            ans += min * Math.pow(10, count);
            count++;
        }
        
        return ans;
    }
}