class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();
        int mod = 1000000007;
        int [] dp = new int [n + 1];
        dp[0] = 1;
        int [] freq = new int [26];
        Arrays.fill(freq, -1);
        for(int i = 0; i < n; i++){
            int x = s.charAt(i) - 'a';
            dp[i + 1] =(dp[i] * 2) % mod; 
            if(freq[x] >= 0){
                dp[i+1] -= dp[freq[x]];
                dp[i+1] = dp[i + 1] % mod;
            }
            freq[x] = i;

        }
        dp[n]--;
        if(dp[n] < 0) dp[n] += mod;
        return dp[n];
    }
}