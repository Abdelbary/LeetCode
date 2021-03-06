class Solution {
    Integer[][] dp = new Integer[1001][1001];
    
    public int longestCommonSubsequence(String text1, String text2) {
        return LCS(text1,text2,0,0);
    }
    
    int LCS(String s1,String s2,int i , int j)
    {
        if(i == s1.length() || j == s2.length())
        {
            return 0;
        }
        if(dp[i][j] != null)
        {
            return dp[i][j];
        }
        
        if(s1.charAt(i) == s2.charAt(j))
        {
            return dp[i][j] = 1+LCS(s1,s2,i+1,j+1);
        }
        
        return dp[i][j] = Math.max(LCS(s1,s2,i+1,j),LCS(s1,s2,i,j+1));
    }
}