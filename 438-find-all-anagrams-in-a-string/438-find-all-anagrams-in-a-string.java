class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        Map<Character,Integer> charFrq = new HashMap<Character,Integer>();
        
        for(char c : p.toCharArray())
        {
            charFrq.put(c,charFrq.getOrDefault(c,0)+1);
        }
        
        int windowStart = 0;
        int charCount = 0;
        
        
        for(int windowEnd = 0 ; windowEnd < s.length() ; windowEnd++)
        {
            char charIn = s.charAt(windowEnd);
            
            if(charFrq.containsKey(charIn))
            {
                charFrq.put(charIn,charFrq.get(charIn)-1);
                
                if(charFrq.get(charIn) == 0)
                    charCount++;
            }
            
            if(charCount == charFrq.size())
                result.add(windowStart);
            
            if(windowEnd - windowStart + 1 >= p.length())
            {
                char charOut = s.charAt(windowStart++);
                
                if(charFrq.containsKey(charOut))
                {
                    if(charFrq.get(charOut) == 0)
                        charCount--;
                    
                    charFrq.put(charOut,charFrq.get(charOut)+1);
                }
            }
        }
        
        return result;
    }
}