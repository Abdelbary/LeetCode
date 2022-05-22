class Solution {
    
    int[] cost;
    Map<Integer,Integer> cache;
    
    private int dp(int i)
    {
        if(i <= 1) return cost[i];
        
        if(!cache.containsKey(i))
            cache.put(i,cost[i]+Math.min(dp(i-1),dp(i-2)));
        
        return cache.get(i);
    }
    
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        this.cache = new HashMap<Integer,Integer>();
        
        return Math.min(dp(cost.length-1),dp(cost.length-2));
    }
}