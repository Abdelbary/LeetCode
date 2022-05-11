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
        int N = matrix.length;
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>((a,b)->(a.val-b.val));
        
        //add first colum to the heap
        for(int i = 0 ; i < N ; i++)
        {
            minHeap.add(new Node(i,0,matrix[i][0])); 
        }
    
        
        Node currentNode = null;
            
        while(k-- > 0)
        {
            
            currentNode = minHeap.poll();
            int nextRow = currentNode.row;
            int nextCol = currentNode.col+1;
            if(nextCol < N) //there are more nodes to add in this row
            {
                minHeap.add(new Node(nextRow,nextCol,matrix[nextRow][nextCol]));
            }
        }
        
        return currentNode.val;
    }
}