class Trie {
    Trie[] childs = new Trie[26];
    boolean isWord;
    
    public Trie() {
        isWord = false;
    }
    
    public void insert(String word) {
       insert(word,0);    
    }
    
    public void insert(String w, int indx)
    {
        if(indx == w.length())
        {
            isWord = true;
            return;
        }
        
        Trie childNode = childs[w.charAt(indx)-'a'];
        
        if(childNode == null)
        {
            childNode = new Trie();
            childs[w.charAt(indx)-'a'] = childNode;
        }
        
        childNode.insert(w,indx+1);
    }
    
    public boolean search(String word) {
        return search(word,0);    
    }
    
    public boolean search(String w, int indx)
    {
        if(indx == w.length())
        {
            return isWord;
        }
        
        Trie childNode = childs[w.charAt(indx)-'a'];
        
        if(childNode == null)
        {
            return false;
        }
        
        return childNode.search(w,indx+1);
    }
    
    public boolean startsWith(String prefix) {
        return startsWith(prefix,0);
    }
    
    public boolean startsWith(String prefix,int indx)
    {
        if(indx == prefix.length())
        {
            return true;
        }
         
        Trie childNode = childs[prefix.charAt(indx)-'a'];
        
        if(childNode == null)
        {
            return false;
        }
        
        return childNode.startsWith(prefix,indx+1);
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */