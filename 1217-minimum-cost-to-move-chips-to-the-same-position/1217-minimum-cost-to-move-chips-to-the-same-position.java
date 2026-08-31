class Solution {
    public int minCostToMoveChips(int[] position) {
        int oddCount = 0;
        for(int num : position){
            if(num % 2 != 0){
                oddCount++;
            }
        }
        return Math.min(oddCount, position.length - oddCount);
    }
}