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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null)
        {
            return null;
        }
         
        TreeNode parentNode = getNodeParent(root,p);
        if(parentNode != null && parentNode.val <= p.val)
        {
            parentNode = null;
        }
        TreeNode childSuccessorNode = getSuccessor(p);
        
        if(childSuccessorNode == null && parentNode == null)
        {
            return null;
        }
        if(childSuccessorNode != null && parentNode != null)
        {
            if(parentNode.val > childSuccessorNode.val)
            {
                return childSuccessorNode;
            }
                return parentNode;
            
        }
        if(childSuccessorNode != null )
        {
            return childSuccessorNode;
        }
        return parentNode;
    }
    
    TreeNode getNodeParent(TreeNode root, TreeNode p)
    {
        
        if(root == null || root == p)
        {
            return null;
        }
        
        if(root.right == p || root.left == p)
        {
            return root;
        }
        
        TreeNode leftNodeResult = getNodeParent(root.left,p);
        TreeNode rightNodeResult = getNodeParent(root.right,p);
        
        if(leftNodeResult != null)
        {
            if(leftNodeResult.val < p.val)
            {
                return root;
            }
            return leftNodeResult;
        }
        if(rightNodeResult != null)
        {
            if(rightNodeResult.val < p.val )
            {
                return root;
            }
            return rightNodeResult;
        }
        
        return null;
    }
    
    TreeNode getSuccessor(TreeNode root)
    {
        if(root == null)
        {
            return null;
        }
        TreeNode successor = root.right;
        
        while(successor != null && successor.left != null)
        {
            successor = successor.left;
        }
        
        return successor;
    }
    
}