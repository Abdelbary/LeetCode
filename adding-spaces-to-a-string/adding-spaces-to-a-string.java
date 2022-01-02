class Solution {
    public String addSpaces(String s, int[] spaces) {
        int spaceI = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++)
        {
            if(spaceI < spaces.length && spaces[spaceI] == i)
            {
                sb.append(" ");
                spaceI++;
            }
            
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}