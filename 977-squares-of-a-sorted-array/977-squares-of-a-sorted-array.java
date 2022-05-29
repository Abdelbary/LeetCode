class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        int ansPos = ans.length-1;
        while(left <= right)
        {
            int lsq = nums[left]*nums[left];
            int rsq = nums[right]*nums[right];
            
            if(rsq >= lsq)
            {
                ans[ansPos] = rsq;
                right--;
            }
            else
            {
                ans[ansPos] = lsq;
                left++;
            }
            
            ansPos--;
        }
        
        return ans;
    }
}