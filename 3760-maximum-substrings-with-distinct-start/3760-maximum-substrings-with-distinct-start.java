class Solution {
    public int maxDistinct(String s) {
        int ans = 0;
        HashMap <Character, Integer> map = new HashMap <>();
        for(int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if(map.get(ch) == 1){
                ans++;
            }
            
        }
        return ans;
    }
}