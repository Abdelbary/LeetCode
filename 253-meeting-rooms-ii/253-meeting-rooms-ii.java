class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->(a[1]-b[1]));
        int currentRooms = 0;
        int maxRooms = 0;
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        for(int[] interval : intervals)
        {
            int start = interval[0];
            int end   = interval[1];
            
            while(pq.isEmpty() == false && pq.peek()[1] <= start)
            {
                pq.poll();
                currentRooms--;
            }
            pq.add(interval);
            currentRooms++;
            maxRooms = Math.max(maxRooms,currentRooms);
        }
        
        return maxRooms;
    }
}
