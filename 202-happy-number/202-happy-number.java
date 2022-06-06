class Solution {
    
    private int calculate(int n)
    {
        int result = 0;
        
        while(n > 0)
        {
            int digit =  n%10;
            n/=10;
            result += digit*digit;
        }
        
        return result;
    }
    public boolean isHappy(int n) {
        if(n == 1)
            return true;
        int fast = n;
        int slow = n;
        
        do{
            fast = calculate(calculate(fast));
            slow = calculate(slow);
        }while(fast != 1 && fast != slow);
        
        
        return (fast == 1);
    }
}