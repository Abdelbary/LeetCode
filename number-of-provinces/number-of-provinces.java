class Solution {
    public class UnionFind{
        int[] root;
        int[] rank;
        int groups;
        
        public UnionFind(int size)
        {
            root = new int[size+1];
            rank = new int[size+1];
            groups = size;
            for(int i = 1 ; i<= size ;i++)
            {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public void union(int x,int y)
        {
            int rootx = find(x);
            int rooty = find(y);
            
            if(rootx != rooty)
            {
                if(rank[rootx] < rank[rooty])
                {
                    root[rootx] = rooty;
                }
                else if(rank[rooty] < rank[rootx])
                {
                    root[rooty] = rootx; 
                }
                else
                {
                    root[rootx] = rooty;
                    rank[rootx]++;
                }
                groups--;
            }
        }
        
        public int find(int x)
        {
            if(root[x] == x) return x;
            
            return root[x] = find(root[x]);
        }
        
        public boolean isConnected(int x,int y)
        {
            return find(x) == find(y);
        }
        
    }
    public int findCircleNum(int[][] isConnected) {
        
        UnionFind uf = new UnionFind(isConnected.length);
        
        for(int i = 0; i < isConnected.length ; i++)
        {
            for(int j = 0 ; j < isConnected[i].length ; j++)
            {
                if(isConnected[i][j] == 1)
                    uf.union(i,j);        
            }
        }
        
        return uf.groups;
    }
}