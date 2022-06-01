class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int windowStart = 0;
        long sum = 1;
        int ans = 0;
        
        for(int windowEnd = 0; windowEnd < nums.length ; windowEnd++)
        {
            sum *= nums[windowEnd];
            
            while(windowStart <= windowEnd && sum >= k)
                sum /= nums[windowStart++];
            
            if(sum < k)
                ans += windowEnd - windowStart + 1;
        }
        
        
        return ans;
    }
}