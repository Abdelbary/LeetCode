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
            //add
            char charIn = s.charAt(windowEnd);
            
            if(map.containsKey(charIn))
            {
                map.put(charIn,map.get(charIn)-1);
                
                if(map.get(charIn) == 0)
                    matchedChars++;
            }
            //fix
            char charOut = s.charAt(windowStart);
            while((windowEnd-windowStart+1 > t.length()) && (!map.containsKey(charOut) || map.get(charOut) < 0))
            {
                windowStart++;
                
                if(map.containsKey(charOut))
                {
                    map.put(charOut,map.get(charOut)+1); 
                }
                
                charOut = s.charAt(windowStart);
                
            }
            
            if(matchedChars == map.size() && minWindowSize > windowEnd-windowStart+1)
            {
                minWindowSize = windowEnd - windowStart + 1;
                minStartPos   = windowStart;
            }
            
        }
        
        return (minStartPos == Integer.MAX_VALUE)? "" :s.substring(minStartPos,minStartPos+minWindowSize);
    }
}