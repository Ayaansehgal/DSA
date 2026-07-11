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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode t=head;
        int len=0;
        while(t!=null){
            len++;
            t=t.next;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        int times=len/k;
        ListNode p1=dummy;
        ListNode curr=head;
        for(int i=0;i<times;i++){
            int count=0;
            ListNode prev=null;
            ListNode p2=curr;
            ;
            while(count <k && curr!=null){
                count++;
                ListNode next=curr.next;
                curr.next=prev;
                prev=curr;
               
               curr=next;
            }
            p1.next=prev;
            p2.next=curr;

            p1=p2;
        }
        return dummy.next;
    }
}