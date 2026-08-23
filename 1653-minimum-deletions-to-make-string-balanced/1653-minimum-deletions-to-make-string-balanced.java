class Solution {
    public int minimumDeletions(String s) {
        int del = 0;
        int countB = 0;

        for (char ch : s.toCharArray()) {

            if (ch == 'b') {
                countB++;
            } else {
                del = Math.min(del + 1, countB);
            }
        }

        return del;
    }
}