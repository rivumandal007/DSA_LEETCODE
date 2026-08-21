class Solution {
    public int mirrorDistance(int n) {
        int temp = n;
        int num = 0;

        while (n != 0) {
            int remainder = n % 10;
            num = num * 10 + remainder;
            n /= 10;
        }

        return Math.abs(temp - num);
    }
}