class Solution {
    public int longestOnes(int[] nums, int k) {    
        
        int right = 0;
        int left  = 0;
        int max = 0;
        int zeros = 0;
        
        while(right < nums.length)
        {
            
            while(zeros <= k && right < nums.length)
            {
                zeros += (nums[right] == 0)? 1 : 0;
                right++;
            }
            
            max = Math.max(max,right-left-1);
            
            while(zeros > k && left < right)
            {
                zeros -= (nums[left] == 0)?1 : 0;
                left++;
            }
        }
        max = Math.max(max,right-left);
        return max;
    }
}