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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
        {
            return null;
        }
        
        if(root.val == p.val || root.val == q.val)
        {
            return root;
        }
        
        TreeNode rightResult = lowestCommonAncestor(root.right,p,q);
        TreeNode leftResult  = lowestCommonAncestor(root.left,p,q);
        
        if(rightResult == null && leftResult == null)
        {
            return null;
        }
        else if(rightResult == null)
        {
            return leftResult;
        }
        else if(leftResult == null)
        {
            return rightResult;
        }
        else
        {
            return root;
        }
    }
}