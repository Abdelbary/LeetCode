class Solution {
    int[] nums;
    Map<Integer,Integer> cache;
    
    private int dp(int i)
    {
        //base cases
        if(i == 0) return nums[0];
        if(i == 1) return Math.max(nums[0],nums[1]);
        if(!cache.containsKey(i))
            cache.put(i,Math.max(dp(i-1),nums[i]+dp(i-2)));
        
        
        return cache.get(i);
    }
    
    public int rob(int[] nums) {
        this.nums = nums;
        cache = new HashMap<Integer,Integer>();
        
        return dp(nums.length-1);
    }
}