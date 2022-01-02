/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Integer,Node> map = new HashMap();

    public Node copyRandomList(Node head) {
        
        Node valHead = copyValues(head);
        
        Node It = head;
        
        int ind = 0;
        
        while(It != null)
        {
            It.val = ind;
            It = It.next;
            ind++;
        }
        
        
        Node newHead = deepCopy(head);
        
        It = newHead;
        
        while(It != null)
        {
            It.val = valHead.val;
            It = It.next;
            valHead = valHead.next;
        }
    
        return newHead;
    }
    
    private Node copyValues(Node head)
    {
        if(head == null)
        {
            return null;
        }
        
        Node curr = new Node(head.val);
        
        curr.next = copyValues(head.next);
        
        return curr;
    }
    
    private Node deepCopy(Node head)
    {
      if(head == null)
      {
        return null;
      }
        

        Node nHead = new Node(head.val);
        map.put(nHead.val,nHead);

        nHead.next = deepCopy(head.next);


        if(head.random == null)
        {
            nHead.random = null;
        }
        else
        {
            System.out.println(head.random.val);
            nHead.random = map.get(head.random.val);
        }

        return nHead;
        
    }
}