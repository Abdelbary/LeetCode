/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer,Node> nodeMap = new HashMap<Integer,Node>();
    public Node cloneGraph(Node node) {
        if(node == null)
        {
            return null;
        }
        Node newNode = new Node(node.val);
        
        nodeMap.put(newNode.val,newNode);
        
        for(Node adjNode : node.neighbors)
        {
            if(nodeMap.containsKey(adjNode.val) == false)
            {
                Node tempNode = cloneGraph(adjNode);
                newNode.neighbors.add(tempNode);
                nodeMap.put(tempNode.val,tempNode);
            }
            else
            {
                newNode.neighbors.add(nodeMap.get(adjNode.val));
            }
        }
        
        return newNode;
    }
}