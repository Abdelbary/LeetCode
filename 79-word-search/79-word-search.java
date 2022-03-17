class Solution {
    int[] dx = new int[]{1,0,-1,0};
    int[] dy = new int[]{0,1,0,-1};
    boolean[][] vis;
    public boolean exist(char[][] board, String word) {
        vis = new boolean[board.length][board[0].length];
        boolean ans = false;
        for(int i = 0 ; i < board.length ; i++)
        {
            for(int j = 0 ; j < board[0].length ; j++)
            {
                vis[i][j] = true;
                ans |= helper(board,word.toCharArray(),0,i,j);
                if(ans) return true;
                vis[i][j] = false;
            }
        }
        return ans;
    }
    
    boolean helper(char[][] board,char[] word,int i,int row,int colum)
    {
        if(i == word.length-1)
        {
            return (word[i] == board[row][colum]);
        }
        
        if(word[i] != board[row][colum])
        {
            return false;
        }
        
       
        boolean ans = false;
        for(int j = 0 ; j < 4 ; j++)
        {
            int newColum = colum + dx[j];
            int newRow   = row + dy[j];
            if(newRow >= 0 && newRow < board.length && newColum >= 0 && newColum <board[0].length && vis[newRow][newColum] == false)
            {
                vis[newRow][newColum] = true;
                ans |= helper(board,word,i+1,newRow,newColum);
                if(ans) return true;
                vis[newRow][newColum] = false;
            }
        }
       
        return ans;
    }
}