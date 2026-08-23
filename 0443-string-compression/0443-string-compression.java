class Solution {
    public int compress(char[] chars) {
        String ans = "";
        int count = 1;

        for (int i = 0; i < chars.length - 1; i++) {
            char ch = chars[i];

            if (ch == chars[i + 1]) {
                count++;
            } else {
                ans += ch;

                if (count > 1) {
                    ans += String.valueOf(count);
                }

                count = 1;
            }
        }
        char ch = chars[chars.length - 1];

        ans += ch;

        if (count > 1) {
            ans += String.valueOf(count);
        }


        for (int i = 0; i < ans.length(); i++) {
            chars[i] = ans.charAt(i);
        }

        return ans.length();
    }
}