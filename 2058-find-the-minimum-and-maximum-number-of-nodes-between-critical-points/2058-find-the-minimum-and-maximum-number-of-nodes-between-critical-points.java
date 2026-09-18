class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode pre = head;
        ListNode current = head.next;
        ListNode Next = current.next;

        int min = Integer.MAX_VALUE;
        int max = -1;

        int currIdx = -1;
        int firstIdx = -1;
        int prevIdx = -1;

        int count = 1;

        while (Next != null) {

            if ((pre.val < current.val && current.val > Next.val) ||
                (pre.val > current.val && current.val < Next.val)) {

                prevIdx = currIdx;
                currIdx = count;

                if (firstIdx == -1) {
                    firstIdx = currIdx;
                }

                if (prevIdx != -1) {
                    min = Math.min(min, currIdx - prevIdx);
                    max = currIdx - firstIdx;
                }
            }

            pre = current;
            current = Next;
            Next = Next.next;
            count++;
        }

        if (min == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        return new int[]{min, max};
    }
}
