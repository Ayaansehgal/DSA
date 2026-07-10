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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode n1=head;
        int x=0;
        while(x<k-1){
            x++;
            n1=n1.next;
        }
        ListNode slow=head,
        fast=n1;
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        int temp=n1.val;
        n1.val=slow.val;
        slow.val=temp;
        return head;
    }
    
}