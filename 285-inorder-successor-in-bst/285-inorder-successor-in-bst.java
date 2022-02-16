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
        
        TreeNode leftTreeResult = inorderSuccessor(root.left,p);
        TreeNode rightTreeResult = inorderSuccessor(root.right,p);
        
        if (leftTreeResult == null && rightTreeResult == null && root.val <= p.val)
        {
            return null;
        }
        int minVal = (1000_000_007);
        TreeNode returnNode = null;
        if(root.val > p.val)
        {
            minVal = root.val;
            returnNode = root;
        }
        if(leftTreeResult != null && leftTreeResult.val < minVal)
        {
            minVal = leftTreeResult.val;
            returnNode = leftTreeResult;
        }
        if(rightTreeResult != null && rightTreeResult.val < minVal)
        {
            minVal = rightTreeResult.val;
            returnNode = rightTreeResult;
        }
        
        return returnNode;
    }
}