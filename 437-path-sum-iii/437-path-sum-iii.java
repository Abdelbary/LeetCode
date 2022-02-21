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
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);
        dfs(root,targetSum,0,map);
        return count;
    }
    
    void dfs(TreeNode root, int targetSum, int sum, Map<Integer,Integer> map)
    {
        if(root == null)
        {
            return;
        }
        
        sum += root.val;
        
        if(map.containsKey(sum-targetSum))
        {
            count+= map.get(sum-targetSum);
        }
        
        map.put(sum,map.getOrDefault(sum,0)+1);
        dfs(root.left,targetSum,sum,map);
        dfs(root.right,targetSum,sum,map);
        
        map.put(sum,map.getOrDefault(sum,1)-1);
        
    }
    
    //sum = 10 ,15,18
    //map {[10,1],[15,1],[18,1],[21,0]}
}