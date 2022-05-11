class Solution {
    private class Node{
        int row;
        int col;
        int val;
        
        public Node(int row,int col,int val)
        {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    boolean[][] vis;
    
    int[] dcol = new int[]{1,0,-1,0};
    int[] drow = new int[]{0,1,0,-1};
    int directions;
    
    private boolean valid(int row,int col,int matrixLen)
    {
        return (row < matrixLen && row >= 0 && col < matrixLen && col >= 0);
    }
        
    public int kthSmallest(int[][] matrix, int k) {     
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>((a,b)->(a.val-b.val));
        vis = new boolean[matrix.length][matrix.length];
        directions = 4;
        
        int nodesCount = 0;
        minHeap.add(new Node(0,0,matrix[0][0]));
        vis[0][0] = true;
        while(!minHeap.isEmpty())
        {
            Node currentNode = minHeap.poll();
            int xx = currentNode.val;
            nodesCount++;
            
            if(nodesCount == k) return currentNode.val;
            
            for(int i = 0 ; i < directions ; i++)
            {
                int nextRow = currentNode.row + drow[i];
                int nextCol = currentNode.col + dcol[i];
                if(valid(nextRow,nextCol,matrix.length) && !vis[nextRow][nextCol])
                {
                    vis[nextRow][nextCol] = true;
                    minHeap.add(new Node(nextRow,nextCol,matrix[nextRow][nextCol]));
                }
            }
        }
        
        return -1;
    }
    
    
}