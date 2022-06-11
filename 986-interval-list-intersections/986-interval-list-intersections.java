class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        /*
            - 2-pointers approach one for each list
            - if overlapping condition met [maxStart > minEnd]:
                -add the overlapped part to answer
            - move to next next valid state for overlapping [move minEnd pointer]
        */
        
        
        int i = 0;
        int j = 0;
        
        List<int[]> overlapping = new ArrayList<int[]>();
        
        while(i < firstList.length && j < secondList.length)
        {
            int maxStart = Math.max(firstList[i][0],secondList[j][0]);
            int minEnd   = Math.min(firstList[i][1],secondList[j][1]);
            
            if(maxStart <= minEnd)//overlapping
            {
                overlapping.add(new int[]{maxStart,minEnd});        
            }
            
            i += (firstList[i][1] <= minEnd)? 1 : 0;
            j += (secondList[j][1] <= minEnd)? 1 : 0;
        }
        
        return overlapping.toArray(new int[overlapping.size()][2]);
    }
}