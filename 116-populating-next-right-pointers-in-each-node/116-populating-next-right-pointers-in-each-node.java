/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null)
        {
            return null;
        }
        
        Deque<Node> queue = new ArrayDeque<Node>();
        queue.offerLast(root);
        
        while(queue.isEmpty() == false)
        {
            int levelSize = queue.size();
            Node previousNode = null;
            for(int i = 0 ; i < levelSize ; i++)
            {
                Node currentNode = queue.removeFirst();
                
                if(currentNode.left != null)
                {
                    queue.offerLast(currentNode.left);
                }
                if(currentNode.right != null)
                {
                    queue.offerLast(currentNode.right);
                }
                
                if(previousNode != null)
                {
                    previousNode.next = currentNode;
                }
                previousNode = currentNode;
            }
        }
        
        return root;
    }
}