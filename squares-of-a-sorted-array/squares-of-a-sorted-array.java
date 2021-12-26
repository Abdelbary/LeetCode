class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        
        int l = 0;
        int r = ans.length-1;
        int pos = ans.length-1;
        while(l <= r)
        {
            int lsq = nums[l]*nums[l];
            int rsq = nums[r]*nums[r];
            
            if(lsq > rsq)
            {
                ans[pos] = lsq;
                pos--;
                l++;
            }
            else
            {
                ans[pos] = rsq;
                pos--;
                r--;
            }
        }
        
        return ans;
    }
}