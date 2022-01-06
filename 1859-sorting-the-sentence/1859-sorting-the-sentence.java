class Pair{
    String s;
    int i;
    
    public Pair(String s, int i)
    {
        this.s = s;
        this.i = i;
    }
}
class Solution {
    public String sortSentence(String s) {
        
        String[] words = s.split(" ");
        StringBuilder ans = new StringBuilder();
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> (x.i - y.i));
       
        for(String w : words)
        {
            pq.add(new Pair(w,w.charAt(w.length()-1) - '0'));
        }
        
        while(pq.isEmpty() == false)
        {
            Pair p = pq.remove();
            p.s = p.s.substring(0,p.s.length()-1);
            ans.append(p.s);
            ans.append(" ");
        }
        
        return ans.toString().trim();
    }
}