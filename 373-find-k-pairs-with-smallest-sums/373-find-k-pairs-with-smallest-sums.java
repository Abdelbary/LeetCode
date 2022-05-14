class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<List<Integer>>(
            (a,b)->((a.get(0)+a.get(1)) - (b.get(0) + b.get(1))));
            
        for(int num1 : nums1)
        {
            pq.add(List.of(num1,nums2[0],0));
        }
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        while(k-- > 0 && !pq.isEmpty())
        {
            List<Integer> current = pq.poll();
            
            ans.add(List.of(current.get(0),current.get(1)));
            
            if(current.get(2) < nums2.length - 1) 
                pq.add(List.of(current.get(0),nums2[current.get(2)+1],current.get(2)+1));
        }
        
        return ans;
    }
}