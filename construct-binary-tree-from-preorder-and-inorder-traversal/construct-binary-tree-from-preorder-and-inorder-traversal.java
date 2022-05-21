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
    int[] preorder;
    int[] inorder;
    Map<Integer,Integer> valueIndx;
    int rootIndx;
    
    TreeNode helper(int left,int right)
    {
        if(left > right) 
            return null;
        int dummy = rootIndx;
        int pivotValue = preorder[rootIndx++];
        int pivotIndx  = valueIndx.get(pivotValue);
        
        TreeNode root = new TreeNode(pivotValue);
        
        //very very important to do the left first and then the right as the preorder array is aligned that way
        root.left  = helper(left,pivotIndx-1);
        root.right = helper(pivotIndx+1,right);
        
        return root;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder  = inorder;
        this.valueIndx = new HashMap<Integer,Integer>();
        rootIndx = 0;
        
        for(int i = 0 ; i < inorder.length ; i++)
            valueIndx.put(inorder[i],i);
        
        return helper(0,inorder.length-1);
    }
}