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
    public int minDepth(TreeNode root) {
        if(root == null)
        {
          return 0;
        }

        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offerLast(root);
        int level = 0;
        while(queue.isEmpty() == false)
        {
          int levelSize = queue.size();
          level++;

          for(int i = 0 ; i < levelSize ; i++)
          {
            TreeNode currentNode = queue.removeFirst();

            if(currentNode.left == null && currentNode.right == null)
            {
              return level;
            }

            if(currentNode.left != null)
            {
              queue.offerLast(currentNode.left);
            }
            if(currentNode.right != null)
            {
              queue.offerLast(currentNode.right);
            }
          }
        }

        return -1;
        }
}