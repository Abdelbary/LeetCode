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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
        {
            return;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        ListNode slowPrev = head;
        while(fast != null && fast.next != null)
        {
            slowPrev  = slowPrev.next;
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null) //mean that the fast.next = null and it alsow means odd numbers of node in the linked list
        {
            slow = slow.next;
            slowPrev = slowPrev.next;
        }
        slowPrev.next = null;
        ListNode nodeA = head;
        ListNode nodeB =   reverse(slow);
        
        while(nodeA != null && nodeB != null)
        {
            ListNode tmp = nodeA.next;
            nodeA.next = nodeB;
            nodeA = tmp;
            
            tmp = nodeB.next;
            nodeB.next = nodeA;
            nodeB = tmp;
            
        }
    }
    
    ListNode reverse(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        
        
        ListNode dHead = new ListNode();
        dHead.next = head;
        ListNode tail = dHead.next;
        ListNode currentNode = tail.next;
        
        while(currentNode != null)
        {
            tail.next = currentNode.next;
            currentNode.next = dHead.next;
            dHead.next = currentNode;
            currentNode = tail.next;
        }
            
        return dHead.next;
    }
}