class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder ss = new StringBuilder();
        
        for(char c : s.toCharArray())
        {
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
            {
                ss.append(c);
            }
        }
        
        
        int l = 0;
        int r = ss.length()-1;
        
        while(l<=r)
        {
            if(ss.charAt(l) != ss.charAt(r))
            {
                return false;
            }
            l++;
            r--;
        }
        
        return true;
    }
}