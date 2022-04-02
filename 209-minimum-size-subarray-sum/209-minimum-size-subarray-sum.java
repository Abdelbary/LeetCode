class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int windowStart = 0 ;
        int windowEnd = 0;
        int windowSum = 0;
        int ans = Integer.MAX_VALUE;
        
        for(windowEnd = 0 ; windowEnd < nums.length ; windowEnd++)
        {
            windowSum += nums[windowEnd];
            
            while(windowSum >= target)
            {
                ans = Math.min(ans,windowEnd-windowStart+1);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }
        
        return (ans == Integer.MAX_VALUE)? 0 : ans;
    }
}