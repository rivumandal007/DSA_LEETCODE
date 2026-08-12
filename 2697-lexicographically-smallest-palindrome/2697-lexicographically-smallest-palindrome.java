class Solution {
    public String makeSmallestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char smaller = (char) Math.min(sb.charAt(i), sb.charAt(j));

            sb.setCharAt(i, smaller);
            sb.setCharAt(j, smaller);

            i++;
            j--;
        }

        return sb.toString();
    }
}