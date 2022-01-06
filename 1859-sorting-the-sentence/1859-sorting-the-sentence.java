class Pair{
    StringBuilder s;
    int i;
    
    public Pair(StringBuilder s, int i)
    {
        this.s = s;
        this.i = i;
    }
}
class Solution {
    public String sortSentence(String s) {
        
        String[] words = s.split(" ");
        String[] ans   = new String[words.length];
        StringBuilder sb = new StringBuilder();
        
        for(String w : words)
        {
            int indx    = w.charAt(w.length() - 1) - '0';
            ans[indx-1] = w;
        }
        
        for(String w : ans)
        {
            sb.append(w);
            sb.deleteCharAt(sb.length()-1);
            sb.append(" ");
        }
        
        return sb.toString().trim();
    }
}