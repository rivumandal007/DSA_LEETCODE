class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {

        int n = words.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i];
            String s = words[i];
            if (isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1))) {
                prefix[i + 1]++;
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            ans[i] = prefix[right + 1] - prefix[left];
        }
        return ans;
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}