class Pair{
    StringBuilder s;
    int i;
    
    public Pair(StringBuilder s, int i)
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
            pq.add(new Pair(new StringBuilder(w),w.charAt(w.length()-1) - '0'));
        }
        
        while(pq.isEmpty() == false)
        {
            Pair p = pq.remove();
            p.s.setLength(p.s.length()-1);
            ans.append(p.s);
            ans.append(" ");
        }
        
        return ans.toString().trim();
    }
}