/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
        {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> levelOrderTraversLists = new ArrayList<List<Integer>>();
        
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offerLast(root);
        
        int currentLevelNodesCount = 1;
        int nextLevelNodesCount = 0;
        int level = 0;
        
        List<Integer> currentLevelNodes = new ArrayList<Integer>();
        
        while(queue.isEmpty() == false)
        {
            TreeNode currentNode = queue.removeFirst();
            currentLevelNodes.add(currentNode.val);
            currentLevelNodesCount--;
            
            
            if(currentNode.left != null)
            {
                queue.offerLast(currentNode.left);
                nextLevelNodesCount++;
            }
            if(currentNode.right != null)
            {
                queue.offerLast(currentNode.right);
                nextLevelNodesCount++;
            }
            if(currentLevelNodesCount == 0)
            {
                level++;
                levelOrderTraversLists.add(currentLevelNodes);
                currentLevelNodes = new ArrayList<Integer>();
                currentLevelNodesCount = nextLevelNodesCount;
                nextLevelNodesCount = 0;
            }
        }
        return levelOrderTraversLists;  
    }
}