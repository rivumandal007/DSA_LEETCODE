class Solution {
    public double averageWaitingTime(int[][] customers) {
        long endTime = 0;
        long waiting = 0;

        for (int[] customer : customers) {
            int arrival = customer[0];
            int time = customer[1];

            endTime = Math.max(endTime, arrival) + time;
            waiting += endTime - arrival;
        }

        return (double) waiting / customers.length;
    }
}