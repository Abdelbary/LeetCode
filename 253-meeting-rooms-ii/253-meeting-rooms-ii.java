class Solution {
    private int firstApproach(int[][] intervals)
    {
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a,b)->(a[1]-b[1]));
        
        int minRooms = Integer.MIN_VALUE;
        
        for(int[] interval : intervals)
        {
            if(!minHeap.isEmpty() && interval[0] >= minHeap.peek()[1] )
                minHeap.poll();
            
            minHeap.add(interval);
            
            minRooms = Math.max(minRooms,minHeap.size());
        }
        
        
        return minRooms;
    }
    
    private int secondApproach(int[][] intervals)
    {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        
        for(int i = 0 ; i < intervals.length ; i++)
        {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        
        int s = 0;
        int e = 0;
        
        int meetingRooms = 0;
        int minRooms = Integer.MIN_VALUE;
        
        while(s < start.length)
        {
            if(start[s] < end[e])
            {
                meetingRooms++;
                s++;
            }
            else
            {
                meetingRooms--;
                e++;
            }
            
            minRooms = Math.max(meetingRooms,minRooms);
        }
        
        return minRooms;
    }
    public int minMeetingRooms(int[][] intervals) {
        
        //return firstApproach(intervals);
        return secondApproach(intervals);
    }
}