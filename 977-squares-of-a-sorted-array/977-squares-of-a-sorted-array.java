class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int pos = nums.length-1;
        int[] ans = new int[nums.length];
        while(right >= left)
        {
            int lsq = nums[left]*nums[left];
            int rsq = nums[right]*nums[right];
            
            if(lsq > rsq)
            {
                ans[pos] = lsq;
                left++;
            }
            else
            {
                ans[pos] = rsq;
                right--;
            }
            pos--;
        }
        
        return ans;
    }
}