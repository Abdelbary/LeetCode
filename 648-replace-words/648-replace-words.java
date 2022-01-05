class Node{
    String pref;
    Node[] childs;
    boolean isWord;
    
    public Node()
    {
        pref = "";
        childs = new Node[26];
        isWord = false;
    }
    
    public void insert(String s)
    {
        Node curr = this;
        
        for(char c : s.toCharArray())
        {
            if(curr.childs[c-'a'] == null)
            {
                curr.childs[c-'a'] = new Node();
            }
            Node prev = curr;
            curr = curr.childs[c-'a'];
            curr.pref = prev.pref + c;
        }
        curr.isWord = true;
    }
    
    public Node findPref(String s)
    {
        Node curr = this;
        
        for(char c : s.toCharArray())
        {
            if(curr.isWord == true)
            {
                return curr;
            }
            if(curr.childs[c-'a'] == null)
            {
                return null;
            }
            
            curr = curr.childs[c-'a'];
        }
        
        return (curr.isWord == true)? curr : null;
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        
        Node trie = new Node();
        
        for(int i = 0 ; i < dictionary.size() ; i++)
        {
            trie.insert(dictionary.get(i));
        }
        
        for(String w : words)
        {
            Node root = trie.findPref(w);
            
            if(root == null)
            {
                sb.append(w);
            }
            else
            {
                sb.append(root.pref);   
            }
            sb.append(" ");
        }
        
        return sb.toString().trim();
    }
}