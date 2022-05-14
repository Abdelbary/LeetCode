class Solution {
     private class Node{
            int value;
            int listIndx;
            int listNum;
            
            public Node(int listNum,int listIndx, int value)
            {
                this.value = value;
                this.listIndx = listIndx;
                this.listNum = listNum;
            }
    }
    
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b)->(a.value - b.value));
        int lowestValue = Integer.MAX_VALUE;
        int heighestValue = Integer.MIN_VALUE;
        int left = lowestValue;
        int right = heighestValue;
        int difference = Integer.MAX_VALUE;
        
        for(int i = 0 ; i < nums.size() ; i++)
        {
            int currentVal = nums.get(i).get(0);
            heighestValue   = Math.max(heighestValue,currentVal);
            right = heighestValue;
            pq.add(new Node(i,0,currentVal));
        }
        
      
        
        while(!pq.isEmpty())
        {
            Node currentNode = pq.poll(); 
            lowestValue = currentNode.value;
            
            if(heighestValue - lowestValue < difference)
            {
                difference = heighestValue - lowestValue;
                right = heighestValue;
                left  = lowestValue;
            }      
            
            if(currentNode.listIndx + 1 == nums.get(currentNode.listNum).size()) break;
            
            int nextValue = nums.get(currentNode.listNum).get(currentNode.listIndx + 1);

            heighestValue = Math.max(heighestValue,nextValue);
            pq.add(new Node(currentNode.listNum,currentNode.listIndx + 1 ,nextValue));

            
        }
        
        return new int[]{left,right};
    }
    
}