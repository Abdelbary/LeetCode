class Solution {
    public int[][] merge(int[][] intervals) {
        //sort them by begin
        List<int[]> newIntervals = new ArrayList<int[]>();
        
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        //[[1,3],[2,6],[8,10],[15,18]]
        
        for(int[] interval : intervals)
        {
            if(newIntervals.isEmpty() || newIntervals.get(newIntervals.size()-1)[1] < interval[0])
            {
                newIntervals.add(interval);
            }
            else
            {
                newIntervals.get(newIntervals.size() - 1)[1] = Math.max(newIntervals.get(newIntervals.size() - 1)[1],interval[1]);
            }
        }
        
        return newIntervals.toArray(new int[newIntervals.size()][2]);
        //loop over them 
            //compare current to next if next is overlaping with current move current to next
            //add to answer 
        
        //return ans
    }
}