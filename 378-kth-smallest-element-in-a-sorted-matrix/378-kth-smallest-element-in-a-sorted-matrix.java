class Solution {
    
    private class Node{
        int col;
        int row;
        int val;
        
        public Node(int row, int col, int val)
        {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    
    
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>((a,b)->(a.val-b.val));
        int N = matrix.length;
        
        //add first colum to the heap
        for(int i = 0 ; i < N ; i++)
        {
            minHeap.add(new Node(i,0,matrix[i][0])); 
        }
    
        
        Node currentNode = null;
            
        while(k-- > 0)
        {
            
            currentNode = minHeap.poll();
            
            if(currentNode.col < N - 1) //there are more nodes to add in this row
            {
                minHeap.add(new Node(currentNode.row,currentNode.col+1,matrix[currentNode.row][currentNode.col+1]));
            }
        }
        
        return currentNode.val;
    }
}