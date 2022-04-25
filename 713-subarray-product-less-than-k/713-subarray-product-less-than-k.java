class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int windowStart = 0;
        int product = 1;
        int ans = 0;
        
        for(int windowEnd = 0 ; windowEnd < nums.length ; windowEnd++)
        {
            product *= nums[windowEnd];
            
            while(windowStart <= windowEnd && product >= k)
            {
                product /= nums[windowStart++];
            }
            
            ans += windowEnd - windowStart + 1;
        }
        
        return ans;
    }
}