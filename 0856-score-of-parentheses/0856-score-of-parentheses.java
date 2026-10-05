class Solution {
    public int scoreOfParentheses(String s) {
        int open = 0;
        int ans = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                open++;
            }else{
                open--;
                if(s.charAt(i - 1) == '('){
                    ans += Math.pow(2, open);
                }
            }
        }
        return ans;
         
    }
}