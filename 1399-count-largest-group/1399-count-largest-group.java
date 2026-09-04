class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int num = i;
            int sum = 0;

            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        int max = Collections.max(map.values());
        int count = 0;

        for (int value : map.values()) {
            if (value == max) {
                count++;
            }
        }

        return count;
    }
}