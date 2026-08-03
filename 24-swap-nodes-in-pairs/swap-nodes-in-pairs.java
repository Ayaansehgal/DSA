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
    public void helper(ListNode prev,ListNode curr){
        if(curr==null || curr.next==null){
            return;
        }
        ListNode f=curr,
        s=curr.next;
        prev.next=s;
        f.next=s.next;
        s.next=f;
        helper(f,f.next);
    }
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode curr=head;
        helper(prev,curr);
        return dummy.next;
    }
}