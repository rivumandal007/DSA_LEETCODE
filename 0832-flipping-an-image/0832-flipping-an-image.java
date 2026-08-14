class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int [][] arr = new int[n][n];
       
        for(int i = 0; i < n; i++){
             int k = n - 1;
            for(int j = 0; j < n; j++){
                if(image[i][k] == 0){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = 0;
                }
                k--;
            }
        }
        return arr;
    }
}