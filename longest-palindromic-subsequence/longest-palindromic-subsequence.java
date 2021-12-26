class Solution {
    int[][] dp = new int[1001][1001];
    
    public int longestPalindromeSubseq(String s) {
            
            for(int i = 0 ; i < s.length() ; i++)
            {
                dp[i][i] = 1;
               // dp[i][s.length()] = 1;
            }
        
            for(int i = 1 ; i < s.length() ; i++)
            {
                for(int j = i-1 ; j >= 0 ; j--)
                {
                    if(s.charAt(i) == s.charAt(j))
                    {
                        dp[i][j] = 2 + dp[i-1][j+1];
                    }
                    else
                    {
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j+1]);
                    }
                }
            }
        
            return dp[s.length()-1][0];
        }
    
    private int plan(String s,int i , int j)
    {
        if(i >j)
        {
            return 0;
        }
        
        if(i == j)
        {
            return 1;
        }
        
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j))
        {
            return dp[i][j] = 2+plan(s,i+1,j-1);
        }
        return dp[i][j] = Math.max(plan(s,i+1,j),plan(s,i,j-1));
    }

}