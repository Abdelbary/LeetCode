class Solution {
    public boolean checkZeroOnes(String s) {
        int maxOnes = 0;
        int maxZeros = 0;
        
        int i =0;
        
        while(i < s.length())
        {
            int oneCount  = 0;
            int zeroCount = 0 ;
            while(i<s.length() && s.charAt(i) == '1')
            {
                oneCount++;
                i++;
            }
            
            maxOnes = Math.max(maxOnes,oneCount);
            
            while(i<s.length() && s.charAt(i) == '0')
            {
                zeroCount++;
                i++;
            }
            
            maxZeros = Math.max(maxZeros,zeroCount);
            
        }
        
        return (maxOnes > maxZeros);
    }
}