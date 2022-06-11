class Solution {
    public int minMeetingRooms(int[][] intervals) {
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
}