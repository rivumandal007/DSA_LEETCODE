class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];
        for (int i = 0; i < order.length(); i++) {
            rank[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {

            String a = words[i];
            String b = words[i + 1];

            int len = Math.min(a.length(), b.length());

            for (int j = 0; j < len; j++) {
                int c1 = rank[a.charAt(j) - 'a'];
                int c2 = rank[b.charAt(j) - 'a'];
                if (c1 < c2) {
                    break;
                }

                if (c1 > c2) {
                    return false;
                }
            }

            if (a.startsWith(b) && a.length() > b.length()) {
                return false;
            }
        }

        return true;
    }
}