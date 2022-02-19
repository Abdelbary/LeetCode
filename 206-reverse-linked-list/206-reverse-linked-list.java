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
    public ListNode reverseList(ListNode head) {
        
//         if(head == null || head.next == null)
//         {
//             return head;
//         }
//         ListNode dhead = new ListNode();
//         dhead.next = head;
//         ListNode tail = dhead.next;
        
//         ListNode currNode = tail.next;
        
//         while(currNode != null)
//         {
//             tail.next = currNode.next;
//             currNode.next = dhead.next;
//             dhead.next = currNode;
//             currNode = tail.next;
//         }
        
//         return dhead.next;
            
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = curr.next;
        
        while(next != null)
        {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }
}