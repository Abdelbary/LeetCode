class Solution {
    
    public String longestPalindrome(String s) {
        int left=  0;
        int right = 0;
        int max = -1;
        for(int i = 0 ; i < s.length() ; i++)
        {
            int len1 = expandPlan(i,i,s);
            int len2 = expandPlan(i,i+1,s);
            int maxLen = Math.max(len1,len2);
            System.out.println(i+" "+maxLen);
            int l = i-((maxLen-1)/2);
            int r = i+(maxLen/2);
            
            if(r - l > max)
            {
                max = r - l;
                left = l;
                right = r;
            }
        }
        
        return s.substring(left,right+1);
    }
    
    public int expandPlan(int i , int j , String s)
    {
        if(s == null || i > j)
        {
            return 0;
        }
        
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j))
        {
            i--;
            j++;
        }
        
    
        return j-i-1;
    }
}