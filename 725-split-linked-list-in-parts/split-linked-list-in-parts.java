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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int l=0;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            l++;
        }
        int u=l/k;
        int rem=l%k;
        curr=head;
        ListNode[]res=new ListNode[k];
        for(int i=0;i<k;i++){
            int c=u;
            if(rem>0){
                c++;
                rem--;
            }
            ListNode temp1=curr;
            int t=0;
            ListNode prev=null;
            while(t<c){
                prev=curr;
                curr=curr.next;
                t++;
            }
            if(prev!=null){
                 prev.next=null;
            }
            res[i]=temp1;
        }
        return res;
    }
}