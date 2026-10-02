class Solution {
    List <String> li = new ArrayList <> ();
    public List<String> generateParenthesis(int n) {
        int close = 0;
        int open = 0;
        solve("", open, close, n);
        return li;
    }
    private void solve(String s, int open, int close, int n){
        if(s.length() == 2 * n){
            li.add(s);
            return;
        }
        
        if (open < n) {
            solve(s + "(", open + 1, close, n);

        }

        if (close < open) {
            solve(s + ")", open, close + 1, n);
        }
    }
}