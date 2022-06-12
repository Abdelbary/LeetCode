class Solution {
    public int firstMissingPositive(int[] nums) {
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            while(nums[i]-1 >= 0 && nums[i]-1 < nums.length && nums[i] != nums[nums[i]-1])
                swap(i,nums[i]-1,nums);
        }
        
        for(int i = 0 ; i < nums.length ;i++)
            if(nums[i]-1 != i)
                return i+1;
        
        
        return nums.length+1;
    }
    
    
    private void swap(int x,int y, int[] nums)
    {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}