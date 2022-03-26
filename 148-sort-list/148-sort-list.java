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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }
        
        ListNode mid = splitAndGetMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeList(left,right);
    }
    
    ListNode mergeList(ListNode left,ListNode right)
    {
        ListNode dHead = new ListNode();
        //attach dhead to the start of the list
        ListNode currentNode = dHead;
        while(left != null && right != null)
        {
            if(left.val < right.val)
            {
                if(currentNode == null)
                {
                    dHead.next = left;
                    currentNode = left;
                }
                currentNode.next = left;
                left = left.next;
            }else{
                if(currentNode == null)
                {
                    dHead.next = right;
                    currentNode = right;
                }
                currentNode.next = right;
                right = right.next;
            }
            currentNode = currentNode.next;
        }
        
        currentNode.next = (left == null)? right : left;
        
        return dHead.next;
    }
    ListNode splitAndGetMid(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return null;
        }
        
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        ListNode prev = head;
        
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        return slow;
    }
}