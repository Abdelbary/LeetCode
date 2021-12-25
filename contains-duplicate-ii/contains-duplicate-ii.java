class Solution {
    //Map<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
    //Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    Set<Integer> s = new HashSet<Integer>();
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int j = 0;
        for(int i =0  ; i < nums.length ; i++)
        {
            if(s.add(nums[i]) == false)
            {
                return true;
            }
            
            if(i-j >= k)
            {
                s.remove(nums[j]);
                j++;
            }
        }
        
        return false;
    }
}