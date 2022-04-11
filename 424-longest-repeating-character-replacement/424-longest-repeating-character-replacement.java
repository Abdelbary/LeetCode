class Solution {
    
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int windowStart = 0;
        int ans = 0;
        int maxElementCount = 0;
        for(int windowEnd = 0 ; windowEnd < s.length() ; windowEnd++)
        {
            //add
            char charToAdd = s.charAt(windowEnd);
            
            map.put(charToAdd,map.getOrDefault(charToAdd,0)+1);
            maxElementCount = Math.max(maxElementCount,map.get(charToAdd));
            
            //fix
            while(windowEnd - windowStart + 1 - maxElementCount > k)
            {
                char charToRemove = s.charAt(windowStart++);
                map.put(charToRemove,map.get(charToRemove)-1);
                
                if(map.get(charToRemove) == 0) map.remove(charToRemove);
                
            }
            
            //update after each shrink
            ans = Math.max(ans,windowEnd - windowStart + 1);
        }
        
        return ans;
    }
}