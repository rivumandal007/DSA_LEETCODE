class Solution {
    public int minimumK(int[] nums) {
        long low = 1;
        long high = 1000000;

        while (low < high) {
            long k = (low + high) / 2;
            long count = 0;

            for (int num : nums) {
                count += (num + k - 1) / k;
            }

            if (count <= k * k) {
                high = k;
            } else {
                low = k + 1;
            }
        }

        return (int) low;
    }
}