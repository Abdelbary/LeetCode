class Solution {
    Set<List<Integer>> set = new HashSet();
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        findRec(nums,0,new ArrayList<Integer>());
        
        List<List<Integer>> l = new ArrayList(set);

        
        return l;
    }
    
    public void findRec(int[] nums,int i, List<Integer> ls)
    {
        if(i == nums.length)
        {
            if(ls.size() > 1 && isSorted(ls))
            {
                set.add(new ArrayList(ls));     
            }
                  
           return;
        }
        
        findRec(nums,i+1,ls);
        ls.add(nums[i]);
        findRec(nums,i+1,ls);
        ls.remove(ls.size()-1);
    }
    
    private boolean isSorted(List<Integer> ls)
    {
        for(int i = 0 ; i < ls.size()-1 ; i++)
        {
            if(ls.get(i) > ls.get(i+1))
            {
                return false;
            }
        }
        
        return true;
    }
}