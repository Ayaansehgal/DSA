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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int len = 0;
        ListNode curr = head;

        while (curr != null) {
            len++;
            curr = curr.next;
        }

        curr = head;
        ListNode prevTail = null;
        int probGroupSize = 1;

        while (curr != null && len > 0) {
            int actualGroupSize = Math.min(probGroupSize, len);

            if (actualGroupSize % 2 == 0) {
                ListNode groupHead = curr;
                ListNode prev = null;

                for (int i = 0; i < actualGroupSize; i++) {
                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                }

                if (prevTail != null) {
                    prevTail.next = prev;
                } else {
                    head = prev;
                }

                groupHead.next = curr;

                prevTail = groupHead;
            } else {
                for (int i = 0; i < actualGroupSize; i++) {
                    prevTail = curr;
                    curr = curr.next;
                }
            }

            len -= actualGroupSize;
            probGroupSize++;
        }

        return head;
    }
}