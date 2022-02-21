class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] cumlativeSum = new int[nums.length+1];
        int ans = 0;
        cumlativeSum[0] = 0;
        
        for(int i = 1 ; i < cumlativeSum.length ; i++)
        {
            cumlativeSum[i] = cumlativeSum[i-1] + nums[i-1];
        }
        
        for(int i =0 ; i < cumlativeSum.length ; i++)
        {
            for(int j = i+1 ; j < cumlativeSum.length; j++)
            {
                if(cumlativeSum[j]-cumlativeSum[i] == k)
                {
                    ans++;
                }
            }
        }
        
        return ans;
    }
}