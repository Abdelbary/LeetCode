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
        if(root == null) return new ArrayList<List<Integer>>();
        
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offerLast(root);
        List<List<Integer>> levelOrderTraverse = new ArrayList<List<Integer>>();
        
        
        while(!queue.isEmpty())
        {
            int levelSize = queue.size();
            List<Integer> currentLevelNodes = new ArrayList<Integer>();
            
            for(int i = 0 ; i < levelSize ; i++)
            {
                TreeNode currentNode = queue.removeFirst();
                currentLevelNodes.add(currentNode.val);
                
                if(currentNode.left  != null) queue.offerLast(currentNode.left);
                if(currentNode.right != null) queue.offerLast(currentNode.right);
            }
            levelOrderTraverse.add(currentLevelNodes);
        }
        
        return levelOrderTraverse;
    }
}