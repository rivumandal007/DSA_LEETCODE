class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder str = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(str.toString());
                str = new StringBuilder();
            } 
            else if (ch == ')') {
                str.reverse();
                str.insert(0, stack.pop());
            } 
            else {
                str.append(ch);
            }
        }

        return str.toString();
    }
}