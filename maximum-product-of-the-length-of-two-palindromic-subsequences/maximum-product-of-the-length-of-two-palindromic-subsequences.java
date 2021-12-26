class Solution {
    int maxProd = 0;
    
    public int maxProduct(String s) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        
        maxProd(s,0,s1,s2);
        
        return maxProd;
    }
    
    public void maxProd(String s , int i , StringBuilder s1 , StringBuilder s2)
    {
        if(i == s.length())
        {
            if(isPlan(s1) && isPlan(s2))
            {
                maxProd = Math.max(maxProd,s1.length()*s2.length());
            }
            return;
        }
        
        s1.append(s.charAt(i));
        maxProd(s,i+1,s1,s2);
        s1.setLength(s1.length()-1);
        
        s2.append(s.charAt(i));
        maxProd(s,i+1,s1,s2);
        s2.setLength(s2.length()-1);
        
        maxProd(s,i+1,s1,s2);
    }
    
    public boolean isPlan(StringBuilder s)
    {
        if(s == null || s.length() == 0)
        {
            return false;
        }
        
        int l = 0;
        int r = s.length()-1;
        
        while(l <= r && s.charAt(l) == s.charAt(r))
        {
            l++;
            r--;
        }
        
        return (l > r);
    }
     
}