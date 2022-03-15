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
        if(head == null)
        {
          return head;
        }

        ListNode dHead = new ListNode();
        dHead.next = head;
        ListNode preReverse = null;
        int pos = 1;
        //we will assume that p and q exist on the list and p is before q
        while(dHead.next != null && pos < left)
        {
          preReverse = dHead.next;
          dHead.next = dHead.next.next;
          pos++;
        }
        //dhead.next is now pointing to p

        ListNode tail = dHead.next;
        ListNode currentNode = tail.next;

        while(currentNode != null && pos < right)
        {
          tail.next = currentNode.next;
          currentNode.next = dHead.next;
          dHead.next = currentNode;
          currentNode = tail.next;
          pos++;
        }
        
        if(preReverse == null)
            return dHead.next;
        
        preReverse.next = dHead.next;
        return head;
    }
}