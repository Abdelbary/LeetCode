class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        List<int[]> overlappingIntervals = new ArrayList<int[]>();
        while(i < firstList.length && j < secondList.length)
        {
            if(Math.max(firstList[i][0],secondList[j][0]) <= Math.min(firstList[i][1],secondList[j][1]))
            {
                int[] overlappedInterval = new int[]{Math.max(firstList[i][0],secondList[j][0]),Math.min(firstList[i][1],secondList[j][1])};
                overlappingIntervals.add(overlappedInterval);
                
                if(firstList[i][1] <= overlappedInterval[1]) i++;
                if(secondList[j][1] <= overlappedInterval[1]) j++;
            }else
            {
                if(firstList[i][1] < secondList[j][1]) i++;
                else j++;
            }
        }
                
        return overlappingIntervals.toArray(new int[overlappingIntervals.size()][2]);
    }
}