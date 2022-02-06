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
    public List<List<Integer>> levelOrder(TreeNode root) {
    if(root == null)
    {
        return new ArrayList<List<Integer>>();
    }
    Deque<TreeNode> q  = new ArrayDeque<TreeNode>();
    q.offerLast(root);
    int currLevelNodeCount = 1;
    int nextLevelNodeCount = 0;
    List<Integer> levelNodes = new ArrayList<Integer>();
    
    List<List<Integer>> levelOrderTraversalArray = new ArrayList<List<Integer>>();

    while(q.isEmpty() == false)
    {
      //System.out.println(q.size());
      TreeNode currentNode = q.removeFirst();
     
      levelNodes.add(currentNode.val);

      currLevelNodeCount--;

      if(currentNode.left != null)
      {
        q.offerLast(currentNode.left);
        nextLevelNodeCount++;
      }
      if(currentNode.right != null)
      {
        q.offerLast(currentNode.right);
        nextLevelNodeCount++;
      }
      
      if(currLevelNodeCount == 0)
      {
        currLevelNodeCount = nextLevelNodeCount;
        nextLevelNodeCount = 0;
        levelOrderTraversalArray.add(levelNodes);
        levelNodes = new ArrayList<Integer>();
      }
    }

    return levelOrderTraversalArray;
  }
    
}
