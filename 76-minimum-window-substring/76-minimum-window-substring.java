class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        
        for(char c : t.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int minStartPos = Integer.MAX_VALUE;
        int minWindowSize = Integer.MAX_VALUE;
        int windowStart = 0;
        int matchedChars = 0;
        for(int windowEnd = 0; windowEnd < s.length() ; windowEnd++)
        {
            char currentChar = s.charAt(windowEnd);
            
            if(map.containsKey(currentChar))
            {
                map.put(currentChar,map.get(currentChar)-1);
                if(map.get(currentChar) == 0) matchedChars++;
            }
            
            char charToRemove = s.charAt(windowStart);
            int windowSize = windowEnd-windowStart+1;
            while(windowSize > t.length() && (!map.containsKey(charToRemove) || map.get(charToRemove) < 0))
            {
                windowStart++;
                windowSize--;

                if(map.containsKey(charToRemove))
                    map.put(charToRemove,map.get(charToRemove)+1);
               
                charToRemove = s.charAt(windowStart);
            }
            
            if(matchedChars == map.size() && windowSize < minWindowSize)
            {
                minWindowSize = windowSize;
                minStartPos = windowStart;
            }
        }
        
        return (minStartPos == Integer.MAX_VALUE)? "" :s.substring(minStartPos,minStartPos+minWindowSize);
    }
}