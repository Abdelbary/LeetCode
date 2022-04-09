class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray())
        {
            if(Character.isAlphabetic(c) || Character.isDigit(c))
            {
                c = Character.toLowerCase(c);
                sb.append(c);
            }
        }
        
        int left = 0;
        int right = sb.length()-1;
        
        while(left < right)
        {
            if(sb.charAt(left++) != sb.charAt(right--)) return false;
        }
        
        return true;
    }
}