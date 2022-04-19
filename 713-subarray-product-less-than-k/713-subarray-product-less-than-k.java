class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        int windowStart = 0;
        int ans = 0;
        int prod = 1;
        for(int windowEnd = 0; windowEnd < nums.length ; windowEnd++)
        {
            prod *= nums[windowEnd];
            
            while(windowStart <= windowEnd && prod >= k)
            {
                prod /= nums[windowStart++];
            }
            
            ans += windowEnd-windowStart+1;
        }
        
        return ans;
    }
}