class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int insertPos = nums.length-1;
        int[] sortedSq = new int[nums.length];
        while(left <= right)
        {
            int lsq = nums[left] * nums[left];
            int rsq = nums[right] * nums[right];
            
            if(lsq > rsq)
            {
                sortedSq[insertPos] = lsq;   
                left++;
            }
            else
            {
                sortedSq[insertPos] = rsq;
                right--;
            }
            
            insertPos--;
        }
        
        return sortedSq;
    }
    
    
}