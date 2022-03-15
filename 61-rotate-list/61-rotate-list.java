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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
        {
            return head;
        }
        
        int listCount = 0;
        ListNode dummy = head;
        ListNode tail = dummy;
        while(dummy != null)
        {
            listCount++;
            dummy = dummy.next;
            if(dummy != null)
            {
                tail = dummy;
            }
        }
        
        k %= listCount;
        
        dummy = head;
        int currentPos = 1;
        while(currentPos < listCount - k)
        {
            dummy = dummy.next;
            currentPos++;
        }
        tail.next = head;
        head = dummy.next;
        dummy.next = null;
        
        return head;
    }
}