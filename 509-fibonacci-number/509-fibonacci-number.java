class Solution {
    public int fib(int n) {
        if(n <= 1) return n;
        
        int fibt_1 = 0;
        int fibt_2 = 1;
        int ans = 0;
        for(int i = 2 ; i <= n ; i++)
        {
            ans = fibt_1 + fibt_2;
            fibt_1 = fibt_2;
            fibt_2 = ans;
        }
        
        return ans;
    }
}