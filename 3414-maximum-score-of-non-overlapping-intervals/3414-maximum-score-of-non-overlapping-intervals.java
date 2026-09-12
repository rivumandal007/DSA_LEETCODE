class Solution {

    class State {
        long score;
        List<Integer> list;

        State() {
            score = 0;
            list = new ArrayList<>();
        }

        State(long score, List<Integer> list) {
            this.score = score;
            this.list = new ArrayList<>(list);
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0); 
            arr[i][1] = intervals.get(i).get(1); 
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;                       
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            ends[i] = arr[i][1];
        }

    
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = binarySearch(ends, i, arr[i][0]);
        }

        State[][] dp = new State[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new State();
            }
        }

        for (int i = 1; i <= n; i++) {

            for (int k = 1; k <= 4; k++) {

                
                State skip = dp[i - 1][k];

                
                State take = new State(
                    dp[prev[i - 1]][k - 1].score + arr[i - 1][2],
                    dp[prev[i - 1]][k - 1].list
                );

                take.list.add(arr[i - 1][3]);

                Collections.sort(take.list);

                dp[i][k] = better(skip, take);
            }
        }

        List<Integer> ans = dp[n][4].list;

        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }


    private int binarySearch(int[] ends, int right, int start) {

        int low = 0;
        int high = right;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (ends[mid] < start) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private State better(State a, State b) {

        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        
        for (int i = 0; i < Math.min(a.list.size(), b.list.size()); i++) {

            if (!a.list.get(i).equals(b.list.get(i))) {
                return a.list.get(i) < b.list.get(i) ? a : b;
            }
        }

    
        return a.list.size() <= b.list.size() ? a : b;
    }
}