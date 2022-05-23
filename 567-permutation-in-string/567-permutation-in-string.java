class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> charFrq = new HashMap<Character,Integer>();
        
        for(char c : s1.toCharArray())
            charFrq.put(c,charFrq.getOrDefault(c,0)+1);
        
        int windowStart = 0;
        int charCount = 0;
        for(int windowEnd = 0 ; windowEnd < s2.length() ; windowEnd++)
        {
            char charIn = s2.charAt(windowEnd);
            
            if(charFrq.containsKey(charIn))
            {
                charFrq.put(charIn,charFrq.get(charIn)-1);
                
                if(charFrq.get(charIn) == 0)
                {
                    charCount++;
                }
            }
            
            if(charCount == charFrq.size())
                return true;
            
            if(windowEnd - windowStart + 1 >= s1.length())
            {
                char charOut = s2.charAt(windowStart++);
                
                if(charFrq.containsKey(charOut))
                {
                    if(charFrq.get(charOut) == 0)
                        charCount--;
                    
                    charFrq.put(charOut,charFrq.get(charOut)+1);
                }
            }
        }
        
        return false;
        
    }
}