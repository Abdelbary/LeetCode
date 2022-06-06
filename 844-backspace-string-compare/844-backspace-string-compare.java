class Solution {
    
    private int getValidIndx(String s,int indx)
    {
        int backSpaceCount = 0;
        while(indx >= 0)
        {
            if(s.charAt(indx) == '#')
                backSpaceCount++;
            
            else if(backSpaceCount > 0)
                backSpaceCount--;
            
            else
                break;
            
            indx--;
        }
        
        return indx;
    }
    public boolean backspaceCompare(String s, String t) {
        int indx1 = s.length()-1;
        int indx2 = t.length()-1;
        
        while(indx1 >= 0 || indx2 >= 0)
        {
            int i1 = getValidIndx(s,indx1);
            int i2 = getValidIndx(t,indx2);
            
            if(i1 < 0 && i2 < 0)
                return true;
            if(i1 < 0 || i2 < 0)
                return false;
            
            if(s.charAt(i1) != t.charAt(i2))
                return false;
            
            indx1 = i1-1;
            indx2 = i2-1;
        }
        
        return true;
    }
}