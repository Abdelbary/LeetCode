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
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
        {
            return null;
        }
        
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        
        while(fast != slow && fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if(fast != slow)
        {
            return null;
        }
        
        slow = head;
        
        while(fast != slow)
        {
            fast = fast.next;
            slow = slow.next;
        }
        
        return fast;
    }
}