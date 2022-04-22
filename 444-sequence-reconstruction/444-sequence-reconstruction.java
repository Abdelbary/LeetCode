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
        boolean ret = true;
        
        if(next != -1)
        {
            ret &= dfs(next);
        }
        
        vis[node] = State.VISITED;
        return ret;
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
        int startNode = -1;
        
        for(int node : adjList.keySet())
        {
            if(inDegree[node] == 0)
            {
                startNode = node;
                sourceCount++;
            }
            
            if(sourceCount == 2)
            {
                return false;
            }
        }
        
        
        if(startNode != -1 )
        {
            return dfs(startNode);
        }
        
        
        return true;
    }
}