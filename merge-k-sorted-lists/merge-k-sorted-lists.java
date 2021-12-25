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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode[] indx = new ListNode[lists.length];
        ListNode ans = null;
        ListNode curr = ans;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((x,y)-> Integer.compare(x.val,y.val));
        
        for(ListNode node : lists)
        {
             if(node != null)
             {
                 pq.offer(node);
             }
        }

        while(pq.isEmpty() == false)
        {
            ListNode tmpNode = pq.poll();
            
            if(tmpNode.next != null)
            {
                pq.offer(tmpNode.next);    
            }

            if(ans == null)
            {
                ans = tmpNode;
                curr = ans;
            }
            else
            {
                curr.next = tmpNode;
                curr = curr.next;
            }
        }
                    
        
        
        return ans;
        
    }
}