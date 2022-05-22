class Solution {
    Map<Integer,Integer> gain;
    Map<Integer,Integer> cache;
    
    private int dp(int num)
    {
        if(num == 0) return 0;
        if(num == 1) return gain.getOrDefault(1,0);
        
        if(!cache.containsKey(num))
        {
            cache.put(num,Math.max(dp(num-1),gain.getOrDefault(num,0)+dp(num-2)));
        }
        
        return cache.get(num);
    }
    public int deleteAndEarn(int[] nums) {
        gain  = new HashMap<Integer,Integer>();
        cache = new HashMap<Integer,Integer>();
        int maxNum = Integer.MIN_VALUE;
        
        for(int num : nums)
        {
            gain.put(num,gain.getOrDefault(num,0)+num);
            maxNum = Math.max(maxNum,num);
        }
        
        return dp(maxNum);
    }
}