class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> set = solve(expression);
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    private Set<String> solve(String s) {
        Set<String> result = new HashSet<>();
        result.add("");

        int i = 0;

        while (i < s.length()) {

            if (s.charAt(i) == '{') {
                int count = 1;
                int j = i + 1;

                while (count > 0) {
                    if (s.charAt(j) == '{') count++;
                    if (s.charAt(j) == '}') count--;
                    j++;
                }

                Set<String> inside = solve(s.substring(i + 1, j - 1));

                Set<String> temp = new HashSet<>();

                for (String a : result) {
                    for (String b : inside) {
                        temp.add(a + b);
                    }
                }

                result = temp;
                i = j;

            } else if (s.charAt(i) == ',') {
                Set<String> right = solve(s.substring(i + 1));

                result.addAll(right);
                return result;

            } else {
                Set<String> temp = new HashSet<>();

                for (String str : result) {
                    temp.add(str + s.charAt(i));
                }

                result = temp;
                i++;
            }
        }

        return result;
    }
}