class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            while(i != nums[i]-1 && nums[nums[i]-1] != nums[i])
            {
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }
        
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(i != nums[i]-1)
                ans.add(i+1);
        }
        
        return ans;
    }
}