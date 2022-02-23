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
    int pathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return pathSum;
    }
    
    //root = 1 ,2 , 1
    //left 2 + right 3
    //pathSum = 2 
    int dfs(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        
        int leftPathSum = dfs(root.left);
        int rightPathSum = dfs(root.right);
        
        if(root.val + leftPathSum + rightPathSum > pathSum)
        {
            pathSum = root.val + leftPathSum + rightPathSum;
        }
        if(root.val + leftPathSum > pathSum)
        {
            pathSum = root.val + leftPathSum;
        }
        if(root.val + rightPathSum > pathSum)
        {
            pathSum = root.val + rightPathSum;
        }
        if(root.val > pathSum)
        {
            pathSum = root.val;
        }
        
        return Math.max(root.val,root.val + Math.max(leftPathSum,rightPathSum));
    }
}