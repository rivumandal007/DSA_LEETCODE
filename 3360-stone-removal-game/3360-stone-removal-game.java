class Solution {
    public boolean canAliceWin(int n) {
        int count = 10;
        while(n - count >= 0){
            n = n - count;
            count--;
        }
        if(count % 2 == 0){
            return false;
        }
        return true;
    }
}