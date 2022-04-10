class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int ans = 0;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 2 ; i++)
        {
            int left = i+1;
            int right = nums.length-1;
            
            while(left < right)
            {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < target)
                {
                    ans+= right-left;
                    left++;
                }
                else right--;
            }
        }
        
        return ans;
    }
}