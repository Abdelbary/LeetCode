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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode ln = head;
        ListNode rn = head;
        ListNode preRevNode = head;
        ListNode postRevNode = head;
        left--;
        right--;
        while(left > 0 && ln != null)
        {
            ln = ln.next;
            rn = rn.next;
            preRevNode = (left > 1)? preRevNode.next : preRevNode;
            left--;
            right--;
        }
        
        while(right > 0 && rn != null)
        {
            rn = rn.next;
            right--;
        }
        postRevNode = rn.next;
        
        reverse(ln,rn.next);
        //System.out.println(preRevNode.val +" "+ ln.val + " " + rn.val+" "+postRevNode.val);

        
        preRevNode.next = rn;   
        
        ln.next = postRevNode;
        
        return (head == ln)? rn : head;
    }
    
    public void reverse(ListNode head,ListNode tail)
    {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = head.next;
        
        while(curr != tail)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //curr.next = prev;
    }
}