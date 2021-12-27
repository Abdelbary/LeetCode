class Solution {
    public String firstPalindrome(String[] words) {
        
        for(String word : words)
        {
            if(isPlan(word))
            {
                return word;
            }
        }
        
        return "";
    }
    
    private boolean isPlan(String s)
    {
        int l = 0;
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