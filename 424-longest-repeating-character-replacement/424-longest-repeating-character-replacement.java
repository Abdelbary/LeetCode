class Solution {
    
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();        
        int windowStart = 0;
        int windowMaxElmentCount = 0;
        int ans = 0;

        for(int windowEnd = 0 ; windowEnd < s.length() ; windowEnd++)
        {
            char charToInsert = s.charAt(windowEnd);
            
            map.put(charToInsert,map.getOrDefault(charToInsert,0)+1);
            windowMaxElmentCount = Math.max(windowMaxElmentCount,map.get(charToInsert));
            
            while(windowEnd - windowStart + 1 - windowMaxElmentCount > k)
            {
                char charToRemove = s.charAt(windowStart++);
                map.put(charToRemove,map.get(charToRemove)-1);
                
                for(int count : map.values())
                {
                  windowMaxElmentCount = Math.max(windowMaxElmentCount,count);
                }
                
                if(map.get(charToRemove) == 0)
                {
                    map.remove(charToRemove);
                }
            }
            
            ans = Math.max(ans,windowEnd-windowStart+1);
        }
        
        return ans;
    }
}