class Solution {
    public int tribonacci(int n) {
        int t_1 = 1;
        int t_2 = 1;
        int t_3 = 0;
        int t   = 0;
        
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        
        for(int i = 3 ; i <= n ; i++)
        {
            t = t_1+t_2+t_3;
            t_3 = t_2;
            t_2 = t_1;
            t_1 = t;
        }
        
        return t;
    }
}