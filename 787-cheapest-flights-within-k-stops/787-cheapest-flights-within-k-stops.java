class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,ArrayList<ArrayList<Integer>>> adjList = new HashMap<Integer,ArrayList<ArrayList<Integer>>>();
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<ArrayList<Integer>>((a,b)->(a.get(1)-b.get(1)));
        int[][] distants = new int[n][k+2];
        
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < k+2 ; j++)
            {
                distants[i][j] = Integer.MAX_VALUE;
            }
        }
        
        
        for(int[] flight : flights)
        {
            adjList.computeIfAbsent(flight[0],x->new ArrayList<ArrayList<Integer>>()).add(new ArrayList<Integer>(List.of(flight[1],flight[2])));
        }
        
        for(int i =0 ; i < n ; i++)
        {
            adjList.computeIfAbsent(i,x->new ArrayList<ArrayList<Integer>>());
        }
        
        pq.add(new ArrayList<Integer>(List.of(src,0,k+1)));
        
         for(int i = 0 ; i < k+2 ; i++)
         {
             distants[src][i] = 0;
         }
        while(pq.isEmpty() == false)
        {
            List<Integer> data = pq.poll();
            int currentNode = data.get(0);
            int distance = data.get(1);
            int hubs = data.get(2);
            
            
            if(currentNode == dst)
            {
                return distance;
            }
            
            if(hubs <= 0) continue;
            
            
            for(ArrayList<Integer> negibour : adjList.get(currentNode))
            {
                //System.out.println(negibour);
                int next = negibour.get(0);
                int coast =  negibour.get(1);
                boolean skip = false;
                for(int i = k+1 ; i >= hubs ; i--)
                {
                    if(distants[next][i] <= distance + coast)
                    {
                        skip = true;
                        break;
                    }
                }
                if(skip) continue;
                //if(distants[next][hubs] <= distance + coast) continue; //have already visited the next node with more hubs and same or less coast
                
                distants[next][hubs-1] = distance + coast;
                pq.add(new ArrayList<Integer>(List.of(next,coast + distance,hubs-1)));
            }
        }
        return -1;
        
    }
}