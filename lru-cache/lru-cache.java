class LRUCache {
    PriorityQueue<Pair> pq;
    Map<Integer,Integer> map;
    int size;
    int capacity;
    int counter;
    public LRUCache(int capacity) {
            pq = new PriorityQueue<>();
            map = new HashMap();
            size = 0;
            counter = 0;
            this.capacity = capacity;
    }
    
    public int get(int key) 
    {
      if(map.containsKey(key))
      {
          //System.out.println("size" + pq.size());
          pq.remove(new Pair(key,0));
          //System.out.println("size" + pq.size());
          counter++;
          pq.offer(new Pair(key,counter));
          return map.get(key);
      }
        else
        {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        //System.out.println("size" + size);
       if(map.containsKey(key) == true)
       {
          // System.out.println("size" + pq.size());
           pq.remove(new Pair(key,0));
           //ystem.out.println("size" + pq.size());
           counter++;
           pq.offer(new Pair(key,counter));
           map.put(key,value);
       }
        else if(size == capacity )
        {
            Pair p = pq.poll();
            //System.out.println(p.key + " " + p.frq);
            map.remove(p.key);
            counter++;
            pq.offer(new Pair(key,counter));
            map.put(key,value);
        }
        else
        {
            map.put(key,value);
            size++;
            counter++;
            pq.offer(new Pair(key,counter));
        }
    }
    
    private class Pair implements Comparable<Pair>{
    int key;
    int frq;
    Pair(int k,int frq)
    {
        this.key = k;
        this.frq = frq;
    }
    @Override
    public int compareTo(Pair o)
    {
        if(this.frq > o.frq)
        {
            return 1;
        }
        return -1;
    }
    
    @Override
    public boolean equals(Object o) 
    {
        // If the object is compared with itself then return true 
        if (o == this) {
            return true;
        }
 
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Pair)) {
            return false;
        }
         
        // typecast o to Complex so that we can compare data members
        Pair p = (Pair) o;
         
        
        return (this.key == p.key);
    }
        
}
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */