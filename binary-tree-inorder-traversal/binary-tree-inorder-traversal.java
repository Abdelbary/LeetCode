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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        
        List<Integer> list = new ArrayList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        
        TreeNode current = root;
        
        while(!stack.isEmpty() || current != null)
        {
            while(current != null) 
            {
                stack.offerLast(current);
                current = current.left;
            }
            current = stack.removeLast();
            list.add(current.val);
            
            current = current.right;
        }
        return list;
    }
}