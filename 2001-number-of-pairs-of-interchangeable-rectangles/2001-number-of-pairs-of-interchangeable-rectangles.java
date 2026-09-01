class Solution {
    public long interchangeableRectangles(int[][] rectangles) {

        HashMap<String, Integer> map = new HashMap<>();
        long ans = 0;

        for (int[] rectangle : rectangles) {
            int w = rectangle[0];
            int h = rectangle[1];
            int g = gcd(w, h);
            w /= g;
            h /= g;
            String ratio = w + "/" + h;
            ans += map.getOrDefault(ratio, 0);
            map.put(ratio, map.getOrDefault(ratio, 0) + 1);
        }

        return ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}