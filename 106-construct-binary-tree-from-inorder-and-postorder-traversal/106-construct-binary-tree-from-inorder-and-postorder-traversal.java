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
    int postIndx;
    int[] postorder;
    int[] inorder;
    Map<Integer,Integer> valueIndx = new HashMap<Integer,Integer>();
    
    TreeNode helper(int left,int right)
    {
        if(left > right)
            return null;
        
        int val = postorder[postIndx--];
        
        TreeNode root = new TreeNode(val);
        
        int mid = valueIndx.get(val);
        
        root.right = helper(mid+1,right);
        root.left = helper(left,mid-1);
        
        return root;
        
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndx = postorder.length-1;
        
        this.postorder = postorder;
        this.inorder = inorder;
        
        for(int i = 0 ; i < inorder.length ; i++)
        {
            valueIndx.put(inorder[i],i);
        }
        
        return helper(0,postorder.length-1);
    }
}