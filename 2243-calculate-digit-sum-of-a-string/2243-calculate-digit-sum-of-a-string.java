
class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int n = sb.length();
        int i = n;

        while(i > k){
            int sum = 0;
            int count = 0;
            int j = 0;
            int idx = 0;

            StringBuilder temp = new StringBuilder();

            while(j < i){
                sum += sb.charAt(j) - '0';
                j++;
                count++;

                if(count == k){
                    temp.append(sum);
                    sum = 0;
                    count = 0;
                    idx++;
                }

                if(j == i && count > 0){
                    temp.append(sum);
                }
            }

            sb = temp;
            i = sb.length();
        }

        return sb.toString();
    }
}
