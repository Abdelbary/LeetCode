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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagLevelOrderLists = new ArrayList<List<Integer>>();
        
        if(root == null)
        {
            return zigzagLevelOrderLists;
        }
        
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offerLast(root);
        boolean leftToRight = true;
        
        while(queue.isEmpty() == false)
        {
            int levelSize = queue.size();
            List<Integer> currentLevelNodes = new LinkedList<Integer>();
            
            
            for(int i = 0 ; i < levelSize ; i++)
            {
                TreeNode currentNode = queue.removeFirst();
                
                if(leftToRight == true)
                {
                    currentLevelNodes.add(currentNode.val);
                }
                else
                {
                    currentLevelNodes.add(0,currentNode.val);
                }
                
                if(currentNode.left != null)
                {
                    queue.offerLast(currentNode.left);
                }
                if(currentNode.right != null)
                {
                    queue.offerLast(currentNode.right);
                }
            }
            leftToRight = !leftToRight;
            
            zigzagLevelOrderLists.add(currentLevelNodes);
        }
        
        return zigzagLevelOrderLists;
    }
}