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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrderBottomList = new LinkedList<List<Integer>>();
        
        if(root == null)
        {
            return levelOrderBottomList;
        }
        
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        
        queue.offerLast(root);
        
        while(queue.isEmpty() == false)
        {
            int levelSize = queue.size();
            List<Integer> currentLevelNodes = new ArrayList<Integer>();
            
            for(int i = 0 ; i < levelSize ; i++)
            {
                TreeNode currentNode = queue.removeFirst();
                currentLevelNodes.add(currentNode.val);
                
                if(currentNode.left != null)
                {
                    queue.offerLast(currentNode.left);
                }
                if(currentNode.right != null)
                {
                    queue.offerLast(currentNode.right);
                }
            }
            
            levelOrderBottomList.add(0,currentLevelNodes);
        }
        return levelOrderBottomList;
    }
}