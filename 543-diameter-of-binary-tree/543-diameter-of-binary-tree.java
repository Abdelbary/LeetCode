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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    int dfs(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
       
        
        int leftDiamater  = dfs(root.left);
        int rightDiamater = dfs(root.right);
        
        if(leftDiamater + rightDiamater > ans)
        {
            ans = leftDiamater + rightDiamater;
        }
        
        return 1 + Math.max(leftDiamater,rightDiamater);
    }
}