class Solution {
    int[] nums;
    int[] multipliers;
    //Map<Pair<Integer,Integer>,Integer> cache ;
    int[][] cache;
    private int dp(int i, int left)
    {
        if(i == multipliers.length) 
            return 0;
        
        int mult = multipliers[i];
        int right = nums.length-1-(i-left);
        
        
        if(cache[i][left] == 0 )//(!cache.containsKey(new Pair(i,left)))
        {
            cache[i][left] = Math.max((mult*nums[left]+dp(i+1,left+1)),(mult*nums[right]+dp(i+1,left)));
            //cache.put(new Pair(i,left),Math.max((mult*nums[left]+dp(i+1,left+1)),(mult*nums[right]+dp(i+1,left))));
        }
        
        return cache[i][left];
        //return cache.get(new Pair(i,left));
    }
    public int maximumScore(int[] nums, int[] multipliers) {
        this.nums = nums;
        this.multipliers = multipliers;
        //cache = new HashMap<Pair<Integer,Integer>,Integer>();
        cache = new int[multipliers.length][multipliers.length];
        
        return dp(0,0);
    }
}