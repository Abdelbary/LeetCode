class Solution {
    public int maxSubArray(int[] nums) {
//         int[] cumlativeSum = new int[nums.length+1];
//         int ans = Integer.MIN_VALUE;
//         for(int i = 0 ; i < nums.length ; i++)
//         {
//             cumlativeSum[i+1] = cumlativeSum[i] + nums[i];
//             ans = Math.max(ans,nums[i]);
//         }
        
//         int minSeenNumber = Integer.MAX_VALUE;
        
//         for(int i = 0 ; i < cumlativeSum.length; i++)
//         {
//              //System.out.print(cumlativeSum[i] + " ");
//              ans = Math.max(ans,cumlativeSum[i]-minSeenNumber);
//              minSeenNumber = Math.min(minSeenNumber,cumlativeSum[i]);
//         }
        
//         return ans;
//   [-2,1,-3,4,-1,2,1,-5,4]
        int currentSum = nums[0];//-2,1,-2,4,3,5,6,1,5
        int maxSum     = nums[0];//-2,1,-2,4,5,6
        
        for(int i = 1; i < nums.length ; i++)
        {
            if(currentSum <= 0)
            {
                currentSum = 0;
            }
            currentSum += nums[i];
            
            maxSum = Math.max(maxSum,currentSum);
        }
        
        return maxSum;
    }
}