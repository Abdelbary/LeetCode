class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        
        return recursiveFourSum(nums,0,target,4); 
    }
    
    public List<List<Integer>> recursiveFourSum(int[] nums,int start,int target, int k)
    {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(k == 2)
            return twoSum(nums,start,target);
        
        if(start == nums.length)
            return result;
        
        
        for(int i = start ; i < nums.length ; i++)
        {
            if(i == start || nums[i] != nums[i-1])
            {
                for(List<Integer> subList : recursiveFourSum(nums,i+1,target - nums[i],k-1))
                {
                    result.add(new ArrayList<>(Arrays.asList(nums[i])));
                    result.get(result.size()-1).addAll(subList);
                }
            }
        }
        
        return result;
    }
    
    public List<List<Integer>> twoSum(int[] nums,int start,int target)
    {
        int left = start;
        int right = nums.length-1;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        while(left < right)
        {
            int sum = nums[left] + nums[right];
          
            if(sum < target || (left > start && nums[left] == nums[left-1]))
                left++;
            else if(sum > target || (right < nums.length-1 && nums[right] == nums[right+1])) 
                right--;
            else
                result.add(Arrays.asList(nums[left++],nums[right--]));
        }
        return result;
    }
}
    
    