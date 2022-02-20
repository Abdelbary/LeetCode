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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root,arr,new ArrayList<Integer>());
    }
    
    boolean dfs(TreeNode root, int[] seq, List<Integer> path)
    {
        if(root == null)
        {
            return false;
        }
        boolean ret = false;
        
        path.add(root.val);
        
        if(root.left == null && root.right == null)
        {
            ret = compare(path,seq);
        }else
        {
            ret = dfs(root.left,seq,path) || dfs(root.right,seq,path);  
        }
        
        path.remove(path.size()-1);
        
        return ret;
    }
    
    boolean compare(List<Integer> path,int[] seq)
    {
        //stem.out.println(path);
        if(path.size() != seq.length)
        {
            return false;
        }
        
        for(int i = 0; i < seq.length ; i++)
        {
            if(seq[i] != path.get(i))
            {
                return false;
            }
        }
        
        return true;
    }
}