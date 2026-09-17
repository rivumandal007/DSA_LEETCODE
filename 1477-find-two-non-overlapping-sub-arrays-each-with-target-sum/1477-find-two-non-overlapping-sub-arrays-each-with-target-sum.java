class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int i = 0;
        int j = 0;
        int result = Integer.MAX_VALUE;
        int currentSum = 0;
        int min = Integer.MAX_VALUE;

        int[] dp = new int[arr.length];

        for (int k = 0; k < arr.length; k++) {
            dp[k] = Integer.MAX_VALUE;
        }

        while (j < arr.length) {
            currentSum += arr[j];

            while (currentSum > target && i <= j) {
                currentSum -= arr[i];
                i++;
            }

            if (currentSum == target) {
                int len = j - i + 1;

                if (i > 0 && dp[i - 1] != Integer.MAX_VALUE) {
                    result = Math.min(result, len + dp[i - 1]);
                }

                min = Math.min(min, len);
            }

            dp[j] = min;
            j++;
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}