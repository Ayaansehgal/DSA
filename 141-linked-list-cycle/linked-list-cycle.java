/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; //
        }

        ListNode temp = head;
        ListNode flag = head.next;

        while (temp != flag) {
            if (flag == null || flag.next == null) {
                return false; 
            }
            temp = temp.next;         
            flag = flag.next.next;     
        }
        return true;
    }
}