/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode,TreeNode> nodeParent = new HashMap<TreeNode,TreeNode>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        List<Integer> distanteKNodes = new ArrayList<Integer>();
        
        dfs(root,null);
        
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        HashSet<TreeNode> visitedNodes = new HashSet<TreeNode>();
        
        queue.offerLast(target);
        
        visitedNodes.add(target);
        int currentLevelNodes = 1;
        int nextLevelNodes    = 0;
        int level = 0;
        
        while(queue.isEmpty() == false)
        {
            if(level == k)
            {
                //System.out.print("size " + queue.size() );
                for(int i = 0 ; i < currentLevelNodes ; i++)
                {
                    distanteKNodes.add(queue.removeFirst().val);   
                }
                break;
            }
            TreeNode currentNode = queue.removeFirst();
            currentLevelNodes--;
            //System.out.println(currentNode.val + " " +  level);
            if(currentNode.left != null && visitedNodes.contains(currentNode.left) == false)
            {
                queue.offerLast(currentNode.left);
                visitedNodes.add(currentNode.left);
                nextLevelNodes++;
            }
            if(currentNode.right != null && visitedNodes.contains(currentNode.right) == false)
            {
                queue.offerLast(currentNode.right);
                visitedNodes.add(currentNode.right);
                nextLevelNodes++;
            }
            if(nodeParent.get(currentNode) != null && visitedNodes.contains(nodeParent.get(currentNode)) == false)
            {
                queue.offerLast(nodeParent.get(currentNode));
                visitedNodes.add(nodeParent.get(currentNode));
                nextLevelNodes++;
            }
            
            if(currentLevelNodes == 0)
            {
                level++;
                currentLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
            }
        }
        
        return distanteKNodes;
    }
    
    void dfs(TreeNode node, TreeNode parent)
    {
        if(node == null)
        {
            return;
        }
        nodeParent.put(node,parent);
        
        dfs(node.right,node);
        dfs(node.left,node);
        
        return;
    }
}