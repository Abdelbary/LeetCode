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
            return null;
        
        
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        
        while(fast != slow && fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast != slow)
            return null;
        
        ListNode nodeA = head;
        ListNode nodeB = fast;
        
        while(nodeA != nodeB)
        {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        
        return nodeA;
    }
}