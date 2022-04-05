class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int windowStart = 0;
        int windowEnd = 0;
        int windowSize = 0;
        int ans = Integer.MIN_VALUE;//3
        Set<Character> set = new HashSet<Character>();//{e}
        Map<Character,Integer> map = new HashMap<Character,Integer>();//{[e,1],[c,0]}
        //eceba //k = 1,0
        for(; windowEnd < s.length() ; windowEnd++)
        {
            char c = s.charAt(windowEnd);
            
            if(!set.contains(c)){
                k--;
                set.add(c);
            }
            map.put(c,map.getOrDefault(c,0)+1);    

            while(k < 0)
            {
                char startChar = s.charAt(windowStart++);
                map.put(startChar,map.get(startChar)-1);
                if(map.get(startChar) == 0){
                    set.remove(startChar);
                    k++;
                } 
            }
            ans = Math.max(ans,windowEnd-windowStart+1);
            
            
                
            
        }
        
        return ans;
    }
}