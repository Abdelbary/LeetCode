class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //loop over the interval till you find an interval where interval[i].end >= newInterval.start
            //if end of newInterval < start of current interval : insert newInterval + inset old interval
            //else insert one interval start = Math.min(newinterval.start,interval.start), end = Math.max(newInterval.end,interval.end)
       
        List<int[]> mergeInterval = new ArrayList<int[]>();
        boolean added = false;
        for(int[] interval : intervals)
        {
            if(added == false && interval[1] >= newInterval[0]) //insert new Interval here
            {
                added = true;
                if(newInterval[1] < interval[0])// if there is now intersaction between the two intervals
                {
                    mergeInterval.add(newInterval);
                    mergeInterval.add(interval);
                }
                else
                {
                    mergeInterval.add(new int[]{Math.min(interval[0],newInterval[0]),Math.max(interval[1],newInterval[1])});
                }
            }
            else
            {
                if(mergeInterval.isEmpty() || interval[0] > mergeInterval.get(mergeInterval.size()-1)[1])
                {
                    mergeInterval.add(interval);    
                }
                else
                {
                    mergeInterval.get(mergeInterval.size()-1)[1] = Math.max(mergeInterval.get(mergeInterval.size()-1)[1],interval[1]);
                }                
            }
        }
        
        if(added == false)
        {
            mergeInterval.add(newInterval);
        }
        
        return mergeInterval.toArray(new int[mergeInterval.size()][2]);
    }
}