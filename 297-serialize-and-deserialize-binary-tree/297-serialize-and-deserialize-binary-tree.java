/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    String tree;
    void serialize(TreeNode root,StringBuilder serialTree)
    {
        if(root == null)
        {
            serialTree.append("null,");
            return;
        }
        
        serialTree.append(root.val);
        serialTree.append(',');
        
        serialize(root.left,serialTree);
        serialize(root.right,serialTree);
        
        return;
    }
    
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        serialize(root,sb);
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
    
    private TreeNode listDeserialzie(List<String> nodes)
    {
        if(nodes.get(0).equals("null"))
        {
            nodes.remove(0);
            return null;
        }
        
        int rootValue = Integer.valueOf(nodes.get(0));
        nodes.remove(0);
        
        TreeNode root = new TreeNode(rootValue);
        
        
        //order is very important
        root.left = listDeserialzie(nodes);
        root.right = listDeserialzie(nodes);
        
        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodesArray = data.split(",");
        
        List<String> nodes = new LinkedList<String>(Arrays.asList(nodesArray));
        
        return listDeserialzie(nodes);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));