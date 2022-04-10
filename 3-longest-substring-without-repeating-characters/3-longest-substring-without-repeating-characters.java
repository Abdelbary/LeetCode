class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int windowStart = 0; 
        int maxWindow = 0;
        for(int windowEnd = 0 ; windowEnd < s.length() ; windowEnd++)
        {
            char charToAdd = s.charAt(windowEnd);
            
            if(map.containsKey(charToAdd))
            {
                windowStart = Math.max(windowStart,map.get(charToAdd)+1); // the first indx after the current char
            }
            
            map.put(charToAdd,windowEnd);
            
            maxWindow = Math.max(maxWindow,windowEnd-windowStart+1);
        }
        
        return maxWindow;
    }
    
}