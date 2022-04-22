class WordDictionary {
    private class Node{
        char c;
        Node[] children;
        boolean isWord;
        
        public Node(char c)
        {
            this.c = c;
            children = new Node[26];
            isWord = false;
        }
    }
    
    Node root;
    public WordDictionary() {
        root = new Node('\0');
    }
    
    public void addWord(String word) {
        Node currentNode = root;
        
        for(char c : word.toCharArray())
        {
            if(currentNode.children[c-'a'] == null) currentNode.children[c-'a'] = new Node(c);
            currentNode = currentNode.children[c-'a'];
        } 
        
        currentNode.isWord = true;
    }
    public boolean DFSsearch(String word,int i,Node node)
    {
        if(node == null) return false;
        if(i == word.length()) return node.isWord;
        
        char currentChar = word.charAt(i);
        boolean ret = false;
        
        if(currentChar == '.')
        {
            for(int j = 0 ; j < 26 ; j++)
            {
                ret |= DFSsearch(word,i+1,node.children[j]);
                
                if(ret)
                    return true;
            }
        }
        else
        {
            return DFSsearch(word,i+1,node.children[currentChar-'a']);    
        }
        
        return false;
    }
    
    public boolean search(String word) {
        return DFSsearch(word,0,root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */