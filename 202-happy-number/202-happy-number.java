class Solution {
    public boolean isHappy(int n) {
        int fast = moveFast(n);
        int slow = moveSlow(n);
        
        while(fast != slow && fast != 1)
        {
            fast = moveFast(fast);
            slow = moveSlow(slow);
        }
        
        if( fast == 1)
        {
            return true;
        }
        return false;
    }
    
    int moveFast(int n)
    {
        int sum = n;
        for(int i = 0 ; i < 2 ; i++)
        {
            sum = moveSlow(sum);
        }
        
        return sum;
    }
    
    int moveSlow(int n)
    {
        int sum = 0;
        while(n > 0)
        {
            sum+= (int)(Math.pow(n%10,2));
            n /=10;
        }
        return sum;
    }
}