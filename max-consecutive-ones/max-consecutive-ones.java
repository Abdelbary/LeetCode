class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0 ;
        int count = 0;
        int i = 0;
        while(i < nums.length)
        {
            count = 0;
            while(i < nums.length && nums[i] == 1)
            {
                count++;
                i++;
            }
            
            max = Math.max(max,count);
            
            i++;
        }
        
        return max;
    }
}