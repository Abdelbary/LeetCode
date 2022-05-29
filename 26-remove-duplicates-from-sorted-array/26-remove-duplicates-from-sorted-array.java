class Solution {
    public int removeDuplicates(int[] nums) {
        int tail = 0;
        
        for(int right = 1 ; right < nums.length ; right++)
        {
            if(nums[right] != nums[tail])
            {
                tail++;
                nums[tail] = nums[right];
            }
        }
        
        return tail+1;
    }
}