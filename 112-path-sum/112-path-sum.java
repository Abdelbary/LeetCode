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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
        {
            return false;
        }
        Deque<TreeNode> nodeStack = new ArrayDeque<TreeNode>();
        Deque<Integer> sumStack = new ArrayDeque<Integer>();
        
        nodeStack.offerLast(root);
        sumStack.offerLast(targetSum);
        
        while(nodeStack.isEmpty() == false)
        {
            TreeNode currentNode = nodeStack.removeLast();
            int currentSum = sumStack.removeLast() - currentNode.val;
            
            if(currentNode.left == null && currentNode.right == null && currentSum == 0)
            {
                return true;
            }
            
            if(currentNode.left != null)
            {
                nodeStack.offerLast(currentNode.left);
                sumStack.offerLast(currentSum);
            }
            if(currentNode.right != null)
            {
                nodeStack.offerLast(currentNode.right);
                sumStack.offerLast(currentSum);
            }
        }
        return false;
        /*
        if(root == null)
        {
            return false;
        }
        if(root.right == null root.val == targetSum)
        {
            return true;
        }
        
        return hasPathSum(root.right,targetSum-root.val) || hasPathSum(root.left,targetSum-root.val);
        */
    }
}