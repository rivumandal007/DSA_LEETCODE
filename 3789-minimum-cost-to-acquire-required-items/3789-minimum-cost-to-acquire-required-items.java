class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long option1 = (long) cost1 * need1 + (long) cost2 * need2;

        int min = Math.min(need1, need2);
        int max = Math.max(need1, need2);

        long option2 = (long) costBoth * min;

        if (need1 > need2) {
            option2 += (long) Math.min(cost1, costBoth) * (need1 - need2);
        } else {
            option2 += (long) Math.min(cost2, costBoth) * (need2 - need1);
        }

        long option3 = (long) costBoth * max;

        return Math.min(option1, Math.min(option2, option3));
    }
}