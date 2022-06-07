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
    private ListNode getMiddle(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        ListNode pre = head;
        while(fast != null && fast.next != null)
        {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        pre.next = null;
        
        return slow;
    }
    
    private ListNode reverseLinkedList(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        
        ListNode dhead = new ListNode();
        dhead.next = head;
        ListNode tail = head;
        ListNode current = head.next;
        
        while(current != null)
        {
            tail.next = current.next;
            current.next = dhead.next;
            dhead.next = current;
            current = tail.next;
        }
        
        return dhead.next;
    }
    public void reorderList(ListNode head) {
        //edge cases
        if(head == null || head.next == null)
            return;
        
        //get  middle
        //reverse second list
        ListNode secondHalf = reverseLinkedList(getMiddle(head));
        
        ListNode newList = head;
        ListNode next1 = head;
        ListNode next2 = secondHalf;
        //reconstruct
        while(head != null && secondHalf != null)
        {
            next1 = head.next;
            next2 = secondHalf.next;
            head.next       = secondHalf;
            
            if(next1 == null && next2 != null) //odd linked list case 
                break;
            secondHalf.next = next1;
            
            head = next1;
            secondHalf = next2;
        }
        
        
    }
}