class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int sLen = s.length();
        int pLen = p.length();
        int matchedChar = 0;
        int windowStart =0;

        for(char c : p.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        List<Integer> anagramsIndxs = new ArrayList<Integer>();
        
        for(int windowEnd = 0 ; windowEnd < sLen ; windowEnd++)
        {
            char currentChar = s.charAt(windowEnd);
            
            if(map.containsKey(currentChar))
            {
                map.put(currentChar,map.get(currentChar)-1);
                if(map.get(currentChar) == 0) matchedChar++;
            }
            
            if(windowEnd-windowStart+1 > pLen)
            {
                char charToRemove = s.charAt(windowStart);
                windowStart++;
                
                if(map.containsKey(charToRemove))
                {
                    if(map.get(charToRemove) == 0) matchedChar--;
                    map.put(charToRemove,map.get(charToRemove)+1);
                }
            }
            
            if(matchedChar == map.size()) anagramsIndxs.add(windowStart);
        }
        
        return anagramsIndxs;
    }
}