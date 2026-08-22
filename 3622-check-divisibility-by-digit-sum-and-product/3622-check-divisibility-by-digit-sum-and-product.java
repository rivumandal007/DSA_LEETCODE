class Solution {
    public boolean checkDivisibility(int n) {
        int digit_sum = 0;
        int product_sum = 1;
        int temp = n;
        while(n != 0){
            int remainder = n % 10;
            digit_sum += remainder;
            product_sum *= remainder;
            n /= 10;

        }
        return temp % (digit_sum + product_sum) == 0 ? true : false;
        
    }
}