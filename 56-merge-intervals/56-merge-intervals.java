class Solution {
    public int[][] merge(int[][] intervals) {
        //sort them by begin
        List<int[]> newIntervals = new ArrayList<int[]>();
        
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        //[[1,3],[2,6],[8,10],[15,18]]
        for(int i  = 0 ; i < intervals.length ;)
        {
            int currentIndx = i;
            int start = intervals[i][0];
            int end = intervals[i][1];
            while(currentIndx+1 < intervals.length && end >= intervals[currentIndx+1][0])
            {
                end = Math.max(end,intervals[currentIndx+1][1]);
                currentIndx++;
            }
            
            if(currentIndx < intervals.length)
            {
                newIntervals.add(new int[]{start,end});
            }
            
            i = currentIndx + 1;
        }
        
        int[][] ans = new int[newIntervals.size()][2];
        
        for(int i = 0 ; i< ans.length ; i++)
        {
            ans[i] = newIntervals.get(i);
        }
        
        return ans;
        //loop over them 
            //compare current to next if next is overlaping with current move current to next
            //add to answer 
        
        //return ans
    }
}