class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        int sLen = s.length();
        int[] frq = new int[26];
        List<Integer> ans = new ArrayList<Integer>();
        
        if(pLen > sLen || sLen == 0 )
        {
            return ans;
        }
        
        for(char c : p.toCharArray())
        {
            frq[c-'a']++;
        }
        
        int left = 0;
        int right = 0;
        int count = pLen;
        
        while(right < sLen)
        {
            if(frq[s.charAt(right)-'a'] >= 1)
            {
                count--;
            }
            frq[s.charAt(right)-'a']--;
            right++;
            
            if(count == 0)
            {
                ans.add(left);
            }
            
            if(right - left == pLen)
            {
                if(frq[s.charAt(left)-'a'] >=0 )
                {
                    count++;
                }
                frq[s.charAt(left)-'a']++;
                left++;
            }
        }
      
        return ans;
    }
}