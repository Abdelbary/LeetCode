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
    List<List<Integer>> pathes = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null)
        {
            return pathes;
        }
        List<Integer> path = new ArrayList<Integer>();
        
        dfs(root,targetSum,path);
        
        return pathes;
    }
    
    void dfs(TreeNode root, int targetSum,List<Integer> path)
    {
        if(root == null)
        {
            return;
        }
        path.add(root.val);
        
        if(root.left == null && root.right == null && root.val == targetSum)
        {
            pathes.add(new ArrayList<Integer>(path));
        }
        
        dfs(root.left,targetSum-root.val,path);
        dfs(root.right,targetSum-root.val,path);
        
        path.remove(path.size()-1);
        
    }
}