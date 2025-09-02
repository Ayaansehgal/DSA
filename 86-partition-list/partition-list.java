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
    public ListNode partition(ListNode head, int x) {
        ListNode LesserHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        ListNode lesser = LesserHead;
        ListNode greater = greaterHead;
        ListNode curr=head;
        while(curr!=null){      
            if (curr.val < x) {
                lesser.next = curr;
                lesser = lesser.next;
            } else {
                greater.next = curr;
                greater = greater.next;
            }
            curr = curr.next; 
        }
            greater.next = null;
            lesser.next = greaterHead.next;
            return LesserHead.next;
    }
}