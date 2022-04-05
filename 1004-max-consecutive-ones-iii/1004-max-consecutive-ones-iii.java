class Solution {
    public int longestOnes(int[] nums, int k) {
        int windowStart = 0;
        int windowZeros = 0;
        int maxWindow = 0;
        for(int windowEnd = 0 ; windowEnd < nums.length ; windowEnd++)
        {
            windowZeros += (nums[windowEnd] == 0)? 1 : 0; //add
            
            while(windowZeros > k)//fix
            {
                windowZeros -= (nums[windowStart++] == 0)? 1 : 0;
            }
            
            maxWindow = Math.max(maxWindow,windowEnd-windowStart+1);//update
        }
        
        return maxWindow;
    }
}