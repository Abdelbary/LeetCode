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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideViewValues = new ArrayList<Integer>();
        if(root == null)
        {
            return rightSideViewValues;
        }
        
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offerLast(root);
        
        while(queue.isEmpty() == false)
        {
            int levelSize = queue.size();
            TreeNode currentNode = null;
            
            for(int i = 0 ; i < levelSize ; i++)
            {
                currentNode = queue.removeFirst();
                
                if(currentNode.left != null)
                {
                    queue.offerLast(currentNode.left);
                }
                if(currentNode.right != null)
                {
                    queue.offerLast(currentNode.right);
                }
            }
            rightSideViewValues.add(currentNode.val);
        }
        return rightSideViewValues;
    }
}
/*
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        int level = 0;
        treeTraverse(root,res,level);
        
        return res;
    }
    
    public void treeTraverse(TreeNode root,List<Integer> res,int level)
    {
        if(root == null)
        {
            return;
        }
        
        if(res.size() == level)
        {
            res.add(root.val);
        }
        
        treeTraverse(root.right,res,level+1);
        treeTraverse(root.left,res,level+1);
    }
}
*/