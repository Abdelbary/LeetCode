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
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null)
        {
            return head;
        }
        int[] frq = new int[201];
        
        ListNode curr = head;
        
        while(curr != null)
        {
            frq[curr.val+100]++;
            curr = curr.next;
        }
        
        curr = head;
        
        while(curr != null && frq[curr.val+100] > 1)
        {
            curr = curr.next;
        }
        
        head = curr;
                    
        while(curr != null && curr.next != null)
        {
            
            if(frq[curr.next.val+100] > 1)
            {
                curr.next = curr.next.next;
            }
            else
            {
                curr = curr.next;
            }
        }
        
        return head;
    
    }
}