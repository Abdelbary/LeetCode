class Solution {
    public int findComplement(int num) {
        int todo = num , bit = 1;
        
        while(todo != 0)
        {
            todo >>=1;
            num = num ^ bit;
            bit <<=1;
        }
        return num;
    }
}