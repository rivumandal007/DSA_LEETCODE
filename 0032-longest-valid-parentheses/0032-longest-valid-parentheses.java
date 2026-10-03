class Solution {
    public int longestValidParentheses(String s) {
        int open = 0; 
        int close = 0;
        int result = 0;
        int n = s.length();
        
        for(int i = 0; i < n; i++){//left to right
            if(s.charAt(i) == '('){
                open++;
            }else{
                close++;
            }

            if(open == close){
                result= Math.max(result, close+open);

            } else if(open < close){
                open = 0;
                close = 0;
            }
        }

        open = 0;
        close = 0;

        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == '('){
                open++;
            }else{
                close++;
            }

            if(open == close){
                result= Math.max(result, close+open);
            } else if(open > close){
                open = 0;
                close = 0;
            }
        }
        return result;
    }
}