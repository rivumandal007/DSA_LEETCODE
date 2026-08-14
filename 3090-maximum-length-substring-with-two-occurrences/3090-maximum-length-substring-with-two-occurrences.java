class Solution {
    public int maximumLengthSubstring(String s) {
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            HashMap <Character, Integer> map = new HashMap<>();
            int currMax = 0;
            for(int j = i; j < s.length(); j++){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                if(map.get(s.charAt(j)) <= 2){
                    currMax++;
                }else{
                    break;
                }

            }
            max = Math.max(currMax, max);
        }
        return max;
        
    }
}