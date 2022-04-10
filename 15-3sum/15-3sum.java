class Solution{
   
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> allPairs = new ArrayList<List<Integer>>();
        
        for(int i = 0 ; i < nums.length -2; i++)
        {
            if(i > 0 && nums[i] == nums[i-1]) continue; //Skip duplicates
            
            twoSums(i,nums,allPairs);
        }
        
        return allPairs;
    }
    
    void twoSums(int start, int[] nums, List<List<Integer>> ans) {
        int left = start+1;
        int right = nums.length - 1;
        
        while(left < right)
        {
            int sum = nums[start] + nums[left] + nums[right];
            
            if(sum == 0)
            {
                ans.add(List.of(nums[start],nums[left++],nums[right--]));
                while(left < right && nums[left] == nums[left-1])left++;
            }
            else if(sum > 0)    right--;
            else                left++;
        }
    }
}