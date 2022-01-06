class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int num_count = 0;
        int lessThanNumCount = 0;
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i] < target)
            {
                lessThanNumCount++;
            }
            else if(nums[i] == target)
            {
                num_count++;
            }
        }
        
        for(int i = 0 ; i < num_count ; i++)
        {
            ans.add(i+lessThanNumCount);    
        }
        
        return ans;
    }
}