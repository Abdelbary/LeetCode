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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
        {
            return head;
        }
        
        ListNode dHead = new ListNode(0);
        dHead.next = head;
        int start = 1;
        int end = k;
        ListNode newHead = head;
        
        for(int i = 0 ; i < k - 1; i++)
        {
            newHead = newHead.next;
        }
        
        int listCount = 0;
        ListNode dummy = head;
        
        while(dummy !=null)
        {
            listCount++;
            dummy = dummy.next;
        }
        
        while(dHead.next != null && end <= listCount)
        {
            dHead.next = reverse(dHead.next,start,end);
            start = end+1;
            end += k;
        }
        
        return newHead;
    }
    
    ListNode reverse(ListNode head, int start , int end)
    {
        if(head == null)
        {
            return head;
        }
        
        ListNode dHead = new ListNode(0);
        dHead.next = head;
        int currentPos = 1;
        ListNode preReverse = null;
        while(dHead.next != null && currentPos < start)
        {
            currentPos++;
            preReverse = dHead.next;
            dHead.next = dHead.next.next;
        }
        
        if(dHead.next == null)
        {
            return null;
        }
        
        ListNode tail = dHead.next;
        ListNode currentNode = tail.next;
        
        while(currentNode != null && currentPos < end)
        {
            currentPos++;
            tail.next = currentNode.next;
            currentNode.next = dHead.next;
            dHead.next = currentNode;
            currentNode = tail.next;
        }
        
        if(preReverse == null)
        {
            return dHead.next;
        }
       
        preReverse.next = dHead.next;
        
        return head;
    }
}