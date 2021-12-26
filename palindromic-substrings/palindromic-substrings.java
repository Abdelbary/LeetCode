class Solution {
    public int countSubstrings(String s) {
        
        int plandCount = 0;
        
        for(int i = 0 ; i < s.length() ; i++)
            for(int j = i ; j < s.length() ; j++)
            {
                if(isPland(s,i,j))
                {
                    plandCount++;
                }
            }
        
        return plandCount;
    }
    
    private boolean isPland(String s, int i , int j)
    {
        if(s.length() == 0 || s == null)
            return false;
        if(i==j)
            return true;
        
        while(i <= j && s.charAt(i) == s.charAt(j))
        {
            i++;
            j--;
        }
        
        return s.charAt(i) == s.charAt(j);
        
    }
}