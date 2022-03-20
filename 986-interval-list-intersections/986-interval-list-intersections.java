class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int indx1 = 0;
        int indx2 = 0;
        List<int[]> ans = new ArrayList();
        
        while(indx1 < firstList.length && indx2 < secondList.length)
        {
            int fs = firstList[indx1][0];
            int fe = firstList[indx1][1];
            int ss = secondList[indx2][0];
            int se = secondList[indx2][1];
            
            //caluclate interval
            int st = Math.max(fs,ss);
            int en = Math.min(fe,se);
            
            if(st <= en)
            {
                ans.add(new int[]{st,en});
            }
            indx1 += (en == fe)?1:0;
            indx2 += (en == se)?1:0;
        }
        
    
        return ans.toArray(new int[ans.size()][2]);
        
    }
}