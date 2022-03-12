class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if(target >= letters[letters.length-1])
        {
            return letters[0];
        }
        
        
        int start = 0 ;
        int end = letters.length;
        int mid;
        
        while(start < end)
        {
         mid = start + (end - start)/2;
            
            if(letters[mid] <= target)
            {
                start = mid + 1;
            }
            else 
            {
                end = mid;
            }
        }
        
        return letters[start];
    }
}