class Solution {
    public boolean isValid(String s) {
        Stack <Character> val = new Stack <> ();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){
                val.push(ch);
            }else{
                if(val.isEmpty()){
                    return false;
                }
            
            if((val.peek() == '(' && ch == ')') ||
               (val.peek() == '{' && ch == '}') ||
               (val.peek() == '[' && ch == ']') 
            
            ){
                val.pop();
            }else{
                return false;
            }
            }
            
        } 
       if(val.isEmpty()){
                return true;
            }else{
                return false;
            }
    
    }
}