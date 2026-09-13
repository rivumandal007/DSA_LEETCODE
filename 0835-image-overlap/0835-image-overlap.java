class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int ans = 0;
        for(int row_off = -n+1; row_off < n; row_off++){
            for(int col_off = -n+1; col_off < n; col_off++){
                int count = overlap(img1, img2, row_off, col_off);
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
    private int overlap(int [][] a, int [][] b, int row_off, int col_off){
        int n = a.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int b_i = i + row_off;
                int b_j = j + col_off;
                if(b_i < 0 || b_i >= n || b_j < 0 || b_j >= n){
                    continue;
                }
                if(a[i][j] == 1 && b[b_i][b_j] == 1){
                    count++;
                }
                
            }
            
        }
        return count;
    }
}