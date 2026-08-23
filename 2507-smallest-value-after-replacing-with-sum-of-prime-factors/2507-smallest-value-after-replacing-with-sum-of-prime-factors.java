class Solution {
    public int smallestValue(int n) {

        while (true) {

            int temp = n;
            int sum = 0;
            for (int i = 2; i <= n / i; i++) {
                while (n % i == 0) {
                    sum += i;
                    n /= i;
                }
            }
            if (n > 1) {
                sum += n;
            }
            if (sum == temp) {
                return sum;
            }
            n = sum;
        }
    }
}