class Solution{
   
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(i == 0 || nums[i] != nums[i-1])
                ans.addAll(twoSum(nums,i+1,nums.length-1,nums[i]));
        }
        
        return ans;
    }
    
    public List<List<Integer>> twoSum(int[] nums,int left,int right,int target)
    {
        List<List<Integer>> triples = new ArrayList<List<Integer>>();
        
        while(left < right)
        {
            int sum = nums[left] + nums[right] + target;
            
            if(sum == 0)
            {
                triples.add(List.of(target,nums[left],nums[right]));
                left++;
                right--;
                while(left < right && nums[left] == nums[left-1]) left++;// to remove duplicates
            }
            else if(sum > 0)
                right--;
            else
                left++;
        }
        
        return triples;
    }
}