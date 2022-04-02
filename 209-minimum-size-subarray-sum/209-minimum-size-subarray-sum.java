class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int windowStart = 0 ;
        int windowEnd = 0;
        int currentSum = 0;
        int ans = Integer.MAX_VALUE;
        while(windowEnd < nums.length)
        {
            if(nums[windowEnd] >= target) return 1;
            
            while(windowEnd < nums.length && currentSum < target)
                currentSum += nums[windowEnd++];
           
            
            while(windowStart < nums.length && currentSum >= target)
            {
                if(currentSum >= target) ans = Math.min(ans,windowEnd-windowStart);
                currentSum -= nums[windowStart++];

            }
                
        }
        
        return (ans == Integer.MAX_VALUE)? 0 : ans;
    }
}