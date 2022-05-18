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
    public boolean isSymmetric(TreeNode root) {
       if(root == null) return true;
        
        return isMirrored(root.left,root.right);
    }

    boolean isMirrored(TreeNode right,TreeNode left)
    {
        if(right == null && left == null)
           return true;
        if((right != null && left == null) || (right == null && left != null))
            return false;
        
        return (right.val == left.val) && (isMirrored(left.left,right.right)) &&                    (isMirrored(left.right,right.left));
    }

}