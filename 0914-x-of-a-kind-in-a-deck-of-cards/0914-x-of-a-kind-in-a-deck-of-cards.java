class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap <Integer, Integer> map = new HashMap <> ();
        for(int card : deck){
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        int ans = 0;
        for(int freq : map.values()){
            ans = gcd(ans, freq);
        }
        return ans >= 2;
    }
    private int gcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}