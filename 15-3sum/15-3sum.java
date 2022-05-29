class Solution{
    private List<List<Integer>> twoSum(int target,int start,int[] nums)
    {
        int left  = start;
        int right = nums.length-1;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        
        while(left < right)
        {
            if(nums[left] + nums[right]  == -target )
            {
                ans.add(List.of(target,nums[left],nums[right]));
                left++;
                right--;
                        
                while(left < nums.length && nums[left] == nums[left-1]) left++; //remove duplicates
            }
            else if(nums[left]+nums[right] > -target)
                right--;
            else
                left++;
        }

        return ans;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triples = new ArrayList<List<Integer>>();
        
        for(int i = 0 ; i < nums.length-2 ; i++)
        {
            if(i == 0 || nums[i] != nums[i-1])
            {
                triples.addAll(twoSum(nums[i],i+1,nums));      
            }
        }
        
        return triples;
    }
}
    
   