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
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        
        stack.offerLast(root);
        
        while(!stack.isEmpty())
        {
            TreeNode current = stack.removeLast();
            list.add(current.val);
            
            if(current.right != null) stack.offerLast(current.right);
            if(current.left != null) stack.offerLast(current.left);
        }
       
        
        return list;
    }
}