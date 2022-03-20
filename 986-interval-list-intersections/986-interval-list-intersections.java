class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        List<int[]> overlappingIntervals = new ArrayList<int[]>();
        while(i < firstList.length && j < secondList.length)
        {
            int maxStart = Math.max(firstList[i][0],secondList[j][0]);
            int minEnd =  Math.min(firstList[i][1],secondList[j][1]);
            if(maxStart <= minEnd )
            {
                overlappingIntervals.add(new int[]{maxStart,minEnd});
                
               
            }
             if(firstList[i][1] <= minEnd) i++;
             if(secondList[j][1] <= minEnd) j++;
        }
                
        return overlappingIntervals.toArray(new int[overlappingIntervals.size()][2]);
    }
}