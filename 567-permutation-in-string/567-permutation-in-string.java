class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int matchedChar = 0;
        
        for(char c : s1.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        for(int windowEnd = 0 ; windowEnd < s2.length() ; windowEnd++)
        {
            char currentChar = s2.charAt(windowEnd);
            if(map.containsKey(currentChar) )
            {
                map.put(currentChar,map.get(currentChar)-1);
                
                if(map.get(currentChar) == 0) matchedChar++;
            }
            
            if(windowEnd >= s1.length())
            {
                char charToRemove = s2.charAt(windowEnd-s1.length());
                if(map.containsKey(charToRemove))
                {
                    if(map.get(charToRemove) == 0) matchedChar--;
                    
                    map.put(charToRemove,map.get(charToRemove)+1);
                }
            }
            
            if(matchedChar == map.size()) return true;
        }
        return false;
    }
}