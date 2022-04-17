class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int insertPos = 0;
        while(insertPos <= right)
        {
            
            if(nums[insertPos] == 0)
            {
                int tmp = nums[left];
                nums[left] = nums[insertPos];
                nums[insertPos] = tmp;
                insertPos++;
                left++;
            }
            else if(nums[insertPos] == 2)
            {
                int tmp = nums[right];
                nums[right] = nums[insertPos];
                nums[insertPos] = tmp;
                right--;
            }
            else    insertPos++;
        }
        
        
    }
}