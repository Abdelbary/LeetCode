class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] frq  = new int[26];
        
        for(char c : s1.toCharArray())
        {
            frq[c - 'a']++;
        }
        
        int count = s1.length();
        int left = 0;
        int right = 0;
        while(right < s2.length())
        {
            if(frq[s2.charAt(right)-'a'] > 0)
            {
                count--;
            }
            //System.out.println(left + " " + right + " " + count);
            frq[s2.charAt(right)-'a']--; 
            right++;
            
            if(count == 0)
            {
                return true;
            }
            
            if(right - left == s1.length())
            {
                if(frq[s2.charAt(left)-'a'] >= 0 )
                {
                    count++;
                }
                frq[s2.charAt(left)-'a']++;
                left++;
            }
        }
        
        return false;
    }
}