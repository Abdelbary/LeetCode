class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,HashMap<String,Double>> adjList = new HashMap<String,HashMap<String,Double>>();
        
        for(int i = 0 ; i < equations.size() ; i++)
        {
            List<String> eq = equations.get(i);
            String a = eq.get(0);
            String b = eq.get(1);
            double value = values[i];
            
            adjList.computeIfAbsent(a,z-> new HashMap<String,Double>()).put(b,value);
            adjList.computeIfAbsent(b,z-> new HashMap<String,Double>()).put(a,1/value);
        }
        
        double[] ans = new double[queries.size()];
        for(int i = 0 ; i < queries.size() ; i++)
        {
            List<String> query = queries.get(i);
            String a = query.get(0);
            String b = query.get(1);
            
            if(adjList.containsKey(a) == false || adjList.containsKey(b) == false)
            {
                ans[i] = -1;
                continue;
            }
            
            Map<String,Double> vis = new HashMap<String,Double>();
            vis.put(a,1.0);
            dfs(adjList,vis,a,b);
            
            if(vis.containsKey(b)) ans[i] = vis.get(b);
            else                   ans[i] = -1;
        }
        
        return ans;
    }
    
    void dfs(Map<String,HashMap<String,Double>> adjList,Map<String,Double> vis,String a,String b)
    {
        if(a == b) return;
        
        for(Map.Entry<String,Double> negihbour : adjList.get(a).entrySet())
        {
            String k = negihbour.getKey();
            double value = negihbour.getValue();
            
            if(vis.containsKey(k) == true) continue;
            vis.put(k,vis.get(a)*value);
            dfs(adjList,vis,k,b);
            
            if(vis.containsKey(b)) return;
        }
    }
}