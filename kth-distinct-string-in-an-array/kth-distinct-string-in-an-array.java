class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> seen  = new HashMap();
        boolean[] duplicate = new boolean[arr.length];
        
        for(int i = 0 ; i < arr.length ; i++)
        {
            String s = arr[i];
            if(seen.containsKey(s) == true)
            {
                   duplicate[i] = true;
                   duplicate[seen.get(s)] = true;
            }
            else
            {
                seen.put(s,i);
            }
        }
     
        
        for(int i = 0 ; i < duplicate.length ; i++)
        {
            if(duplicate[i] == false)
            {
                k--;
            }
            if(k == 0)
            {
                return arr[i];
            }
        }
        return "";
    }
}