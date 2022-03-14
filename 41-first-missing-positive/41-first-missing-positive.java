class Solution {
    public int firstMissingPositive(int[] nums) {
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            while(nums[i]-1 >= 0 && nums[i]-1 < nums.length && nums[i] != nums[nums[i]-1])
            {
                swap(nums,i,nums[i]-1);
            }
        }
        for(int i = 0 ; i < nums.length ; i++)
        {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        for(int i = 0 ; i < nums.length ; i++)
        {
            
            if(i != nums[i]-1)
            {
                return i+1;
            }
        }
        
        return nums.length+1;
    }
    
    void swap(int[] nums,int i,int j)
    {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}