class Solution {
    public String frequencySort(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue( Collections.reverseOrder() );
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        
        for(char c : s.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        for(char k : map.keySet())
        {
            Pair p = new Pair(k,map.get(k));
            pq.add(p);
        }
        StringBuilder sb = new StringBuilder();
        
        while(pq.isEmpty() == false)
        {
            Pair p = pq.poll();
            
            while(p.f > 0)
            {
                sb.append(p.c);
                p.f--;
            }
        }
        
        return sb.toString();
    }
    
    class Pair implements Comparable<Pair>{
        char c;
        int f;
        
        Pair(char c, int f)
        {
            this.c = c;
            this.f = f;
        }
        
        @Override
        public int compareTo(Pair o)
        {
            return this.f-o.f;
        }
    }
}