class Solution{
   
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> allPairs = new ArrayList<List<Integer>>();
        
        for(int i = 0 ; i < nums.length -2; i++)
        {
            while(i > 0 && i < nums.length && nums[i] == nums[i-1]) i++;
            
            int left = i + 1;
            int right = nums.length-1;
            
            while(i < nums.length-2 && left < right)
            {
                int sum = nums[left] + nums[right] + nums[i];
                if(sum == 0)
                {
                    allPairs.add(List.of(nums[i],nums[left++],nums[right--]));
                    while(left < right && nums[left] == nums[left-1])   left++;
                }
                else if(sum >  0)
                {
                        right--;
                }
                else
                {
                    left++;
                }
            }
        }
        
        return allPairs;
    }
}