class Solution {
    public int countOdds(int low, int high) {
        
        int count = 0;
        int i = low % 2 != 0 ? low : low + 1;
        while(i <= high){
            count++;
            i += 2;
        }
        return count;
    }
}