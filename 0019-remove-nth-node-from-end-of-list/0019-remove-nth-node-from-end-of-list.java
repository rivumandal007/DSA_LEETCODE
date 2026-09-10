/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            return null;
        }
        ListNode left = head;
        ListNode right = head;
        ListNode pre = head;
        for(int i = 1; i < n; i++){
            right = right.next;
        }
        while(right.next != null){
            right = right.next;
            pre = left;
            left = left.next;
        }
        if(left == head){
            head = head.next;
            return head;
        }

        pre.next = left.next;
        return head;
        


    }
}