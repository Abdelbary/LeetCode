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
    int ans;
    private void  maxDepthRecursive(TreeNode root,int level)
    {
        if(root == null) return;
        
        if(root.left == null && root.right == null) ans = Math.max(ans,level);
        
        maxDepthRecursive(root.left,level+1);
        maxDepthRecursive(root.right,level+1);
    }
    
    public int maxDepth(TreeNode root) {
        ans = 0;
        
        if(root == null) return ans;
        
        maxDepthRecursive(root, 1);
        
        return ans;
    }
}