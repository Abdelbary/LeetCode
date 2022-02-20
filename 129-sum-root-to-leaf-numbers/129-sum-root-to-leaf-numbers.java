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
    public int sumNumbers(TreeNode root) {
        int pathSums = 0;
        
        return dfs(root,pathSums);
    }
    
    int dfs(TreeNode root, int pathSums)
    {
        if(root == null)
        {
            return 0;
        }
        pathSums = pathSums*10+ root.val;
        
        if(root.left == null && root.right == null)
        {
            return pathSums;
        }
        
        return dfs(root.left,pathSums) + dfs(root.right,pathSums);
    }
}