class Solution {
    int[][] dp = new int[1001][1001];
    
    public int longestPalindromeSubseq(String s) {
            
            for(int[] a : dp)
            {
                Arrays.fill(a,-1);
            }
            return plan(s,0,s.length()-1);
        
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