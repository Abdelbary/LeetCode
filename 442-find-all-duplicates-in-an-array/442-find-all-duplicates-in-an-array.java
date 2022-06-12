class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();        
        List<Integer> result = new ArrayList<Integer>();
        
        for(int num : nums)
        {
            if(set.contains(num))
                result.add(num);
            else
                set.add(num);
        }
        
        return result;
    }
}