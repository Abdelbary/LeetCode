class Solution {
    public int maxPower(String s) {
        
        int max = -1;
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            max = Math.max(max,pow(s,i));
        }
        return max;
    }
    
    private int pow(String s, int i)
    {
        int count = 1;
        
        while(i < s.length()-1 && s.charAt(i) == s.charAt(i+1))
        {
            count++;
            i++;
        }
        
        return count;
    }
}