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
        if(head==null)return head;
        ListNode temp=head;
        int n=0;
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        if(k>n){
            return head;
        }
        if(2*k-1==n){
            return head;
        }
        ListNode start=null;
        ListNode x=head;
        for(int i=1;i<k;i++){
            start=x;
            x=x.next;
        }
        ListNode end=null;
        ListNode y=head;
        for(int i=1;i<n-k+1;i++){
            end=y;
            y=y.next;
        }
        if(start!=null){
            start.next=y;
        }
        if(end!=null){
            end.next=x;
        }
        ListNode flag=x.next;
        x.next=y.next;
        y.next=flag;
        if (k == 1) head = y;
        if (k == n) head = x;
        return head;
     }
}