class Node{
    Node[] childs;
    boolean isWord;
    String pref = "";
    
    public Node()
    {
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
            //System.out.println("prev.prev>> "+ prev.pref +"."+c);
            curr.pref = prev.pref + c;
        }
        
        curr.isWord = true;
    }
    
    public Node findprefNode(String pref)
    {
        Node curr = this;
        for(char c : pref.toCharArray())
        {
            if(curr.childs[c-'a'] == null)
            {
                return null;
            }
            curr = curr.childs[c-'a'];
        }
        return curr;
    }
    
   
    
}
class Solution {
    List<List<String>> res = new ArrayList();
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node trie = new Node();
        
        for(String prod : products)
        {
            trie.insert(prod);
        }
        
        for(int i = 1 ; i <= searchWord.length(); i++)
        {
            String subs = searchWord.substring(0,i);
            Node pref = trie.findprefNode(subs);
            
            //System.out.println(subs + " " + pref.pref);
            
            dfs(pref);
            
        }
        
        return res;
    }
    
    public void dfs(Node pref)
    {
        if(pref == null)
        {
            res.add(new ArrayList());
            return;
        }
        List<String> ls = new ArrayList();
        PriorityQueue<Node> pq = new PriorityQueue<Node>((s,k) -> (s.pref.compareTo(k.pref)));

        int count = 0;
        
        pq.add(pref);
        
        while(pq.isEmpty() == false)
        {
            Node curr = pq.remove();
            //System.out.println(">> " + curr.pref);

            if(curr.isWord == true)
            {
                //System.out.println(count + ">> " + curr.pref);
                ls.add(curr.pref);
                count++;
            }
            
            if(count == 3)
            {
                res.add(ls);
                
                return;
            }
            
            for(int i = 0 ; i < 26 ; i++)
            {
                if(curr.childs[i] != null)
                {
                    //System.out.println("HI");
                    pq.add(curr.childs[i]);
                }
            }        
        
        }
        res.add(ls);
    }
}