class Solution {
    public int removeDuplicates(int[] nums) {
        int pos;
        int nextUnique  = 0;
        for(pos = 0 ; nextUnique < nums.length ; pos++)
        {
            nums[pos] = nums[nextUnique++];
            
            while(nextUnique <  nums.length && nums[nextUnique] == nums[nextUnique-1]) nextUnique++;
        }
        
        return pos;
    }
}