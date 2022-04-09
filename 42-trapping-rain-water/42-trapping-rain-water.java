class Solution {
    public int trap(int[] height) {
        
        int maxL = 0;
        int maxR = 0;
        int left = 0;
        int right = height.length-1;
        int trappedWater = 0;
        while(left <= right)
        {
            if(maxL <= maxR)
            {
                trappedWater += Math.max(maxL-height[left],0);
                maxL = Math.max(maxL,height[left++]);
            }
            else
            {
                trappedWater += Math.max(maxR-height[right],0);
                maxR = Math.max(maxR,height[right--]);
            }
        }
        
        return trappedWater;
    }
}