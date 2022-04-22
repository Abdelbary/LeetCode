enum State{
    UNVISITED,VISITED,VISITING
}

class Solution {
    Map<Integer,ArrayList<Integer>> adjList;
    State[] vis;
    int[] inDegree;
    boolean dfs(int node)
    {
        if(vis[node] == State.VISITING) return false;
        if(vis[node] == State.VISITED)  return true;
        
        vis[node] = State.VISITING;
        int sourceCount = 0;
        int next = -1;
        for(int adj : adjList.get(node))
        {
            inDegree[adj]--;
            if(inDegree[adj] == 0)
            {
                next = adj;
                sourceCount++;
            }
            
            if(sourceCount == 2)
            {
                return false;
            }
        }
        
        if(next != -1)
        {
            dfs(next);
        }
        
        vis[node] = State.VISITED;
        return true;
    }
    
    
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        
        adjList = new HashMap<Integer,ArrayList<Integer>>();
        vis  = new State[nums.length+1];
        inDegree = new int[nums.length+1];
        
        for(int i : nums)
        {
            adjList.computeIfAbsent(i,x->new ArrayList<Integer>());
            vis[i] = State.UNVISITED;
        }
        
        for(List<Integer> seq : sequences)
        {
            for(int i = 0 ; i < seq.size()-1 ; i++)
            {
                int a = seq.get(i);
                int b = seq.get(i+1);
                adjList.get(a).add(b);
                inDegree[b]++;
            }
        }
        //System.out.println(adjList);
        int sourceCount = 0;
        
        for(int start : adjList.keySet())
        {
            if(inDegree[start] == 0)
            {
                sourceCount++;
            }
            
            if(sourceCount == 2)
            {
                return false;
            }
        }
        
        
        for(int start : adjList.keySet())
        {
            
            if(inDegree[start] == 0 )
            {
                if( dfs(start) == false)
                {
                    return false;
                }
            }
        }
        
        return true;
    }
}