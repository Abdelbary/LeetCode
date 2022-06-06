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
    
    private ListNode reverseLinkedList(ListNode head)
    {
        if(head == null)
            return head;
        
        ListNode dhead = new ListNode();
        
        dhead.next = head;
        ListNode tail = head;
        ListNode current = tail.next;
        
        while(current != null)
        {
            tail.next = current.next;
            current.next = dhead.next;
            dhead.next = current;
            current = tail.next;
        }
        
        return dhead.next;
    }
    private ListNode getSecondMiddle(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        ListNode pre  = head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        
        if(fast != null)//odd need to jump middle node [fast.next == null]
            slow = slow.next;
        
        
        pre.next = null;
        
        return slow;
        
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        
        ListNode half = getSecondMiddle(head);
        half          = reverseLinkedList(half);
        while(half != null && head != null)
        {
            if(half.val != head.val)
                return false;
            
            half = half.next;
            head = head.next;
        }
        
        return (half == null && head == null);
    }
}