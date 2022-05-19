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
    private boolean countUniSubtrees(TreeNode root)
    {
        //base case if node == null return false;
        //base case if node is leaf increment the ans and return true;
        //if right tree is uniTree and left tree is uniTree and they have the same value as the node value {incremenat ans; return true;}
        if(root == null) return false;
        
        if(root.left == null && root.right == null)
        {
            ans++;
            return true;
        }
        
        boolean isValid = true;
        
        if(root.left != null)
        {
            isValid &= countUniSubtrees(root.left) && (root.val == root.left.val);
        }
        
        if(root.right != null)
        {
            isValid &= countUniSubtrees(root.right) && (root.val == root.right.val);
        }
        
        if(isValid) ans++;
        
        return isValid;
        
    }
    public int countUnivalSubtrees(TreeNode root) {
        ans = 0;
        countUniSubtrees(root);
        return ans;
    }
}