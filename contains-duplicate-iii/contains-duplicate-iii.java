class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //Map<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        TreeSet<Long> set = new TreeSet();
        int j = 0;
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            Long floor = set.floor((long)nums[i]);
            Long ceil  = set.ceiling((long)nums[i]);
            
            //System.out.println(floor + " " + ceil);
            if((floor != null && Math.abs(floor-nums[i]) <= t) || 
               (ceil != null && Math.abs(ceil-nums[i]) <= t))
            {
                return true;
            }
            set.add((long)nums[i]);
            
            if(i-j == k)
            {
                set.remove((long)nums[j]);
                j++;
            }
        }
        
        return false;
    }
}