class Solution {
    public int[] findDegrees(int[][] matrix) {
        int [] deg = new int[matrix.length];
        for(int j = 0; j < matrix.length; j++){
            for(int i = 0; i < matrix.length; i++){
                deg[j] += matrix[i][j]; 
            }
        } 
        return deg;
    }
}