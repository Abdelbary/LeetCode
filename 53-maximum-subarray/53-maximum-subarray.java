class Solution {
    public int maxSubArray(int[] nums) {
        int[] cumlativeSum = new int[nums.length+1];
        int ans = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++)
        {
            cumlativeSum[i+1] = cumlativeSum[i] + nums[i];
            ans = Math.max(ans,nums[i]);
        }
        
        int minSeenNumber = Integer.MAX_VALUE;
        
        for(int i = 0 ; i < cumlativeSum.length; i++)
        {
             //System.out.print(cumlativeSum[i] + " ");
             ans = Math.max(ans,cumlativeSum[i]-minSeenNumber);
             minSeenNumber = Math.min(minSeenNumber,cumlativeSum[i]);
        }
        
        return ans;
    }
}