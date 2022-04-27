class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean sorted = true;
        
        for(int i = 1 ;i < nums.length ; i++)
        {
            if(nums[i] < nums[i-1])
                sorted = false;
            if(!sorted) 
                min = Math.min(min,nums[i]);
        }
        sorted = true;
        
        for(int i = nums.length-2; i >= 0 ; i--)
        {
            if(nums[i] > nums[i+1])
                sorted = false;
            
            if(!sorted)
                max= Math.max(max,nums[i]);
        }
        
        int left,right;
        
        for( left = 0 ; left < nums.length ; left++)
        {
            if(nums[left] > min) 
                break;
        }
        
        for( right = nums.length-1; right >= 0 ; right--)
        {
            if(nums[right] < max)
                break;
        }
        
        return (min == Integer.MAX_VALUE)?0:right-left+1;
    }
}