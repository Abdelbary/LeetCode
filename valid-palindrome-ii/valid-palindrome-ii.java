class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        StringBuilder sb = new StringBuilder(s);

        while(l <= r)
        {
            if(s.charAt(l) != s.charAt(r) )
            {
                StringBuilder s1 = new StringBuilder(s);
                StringBuilder s2 = new StringBuilder(s);
                
                s1.deleteCharAt(l);
                s2.deleteCharAt(r);
                
                //System.out.println(s1 + "  " + s2);
                
                if(isPlan(s1) == true || isPlan(s2) == true)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else if(s.charAt(l) != s.charAt(r))
            {
                return false;
            }
            
            l++;
            r--;
        }
        
        return true;
    }
    
    private boolean isPlan(StringBuilder s)
    {
        int l = 0 ;
        int r = s.length()-1;
        
        while(l <= r)
        {
            if(s.charAt(l) != s.charAt(r))
            {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}