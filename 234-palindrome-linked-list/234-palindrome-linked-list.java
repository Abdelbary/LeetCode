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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
        {
            return true;
        }
        
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast == null)//even linked list
        {
           slow = reverse(slow);
        }
        else //odd linked list 
        {
            slow.next = reverse(slow.next);  
            slow = slow.next;
        }
        
        ListNode current = head;
        while(slow != null && slow.val == current.val)
        {
            slow = slow.next;
            current = current.next;
        }
        
        return (slow == null);
    }
    
    ListNode reverse(ListNode head)
    {
        if(head == null)
        {
            return null;
        }
        //1,2,3
        ListNode dHead = new ListNode();
        dHead.next = head; //1
        ListNode tail = dHead.next;//1
        ListNode currentNode = tail.next;//2
        
        while(currentNode != null)
        {
            tail.next = currentNode.next;//1-2-3 -> 2-1-3
            currentNode.next = dHead.next;
            dHead.next = currentNode;
            currentNode = tail.next;
        }
        
        return dHead.next;
    }
}