class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = (board.length*board.length) ;
       
        boolean[] visited = new boolean[n+1];
        
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        
        Map<Integer,Integer> map = new HashMap<>();
        
        
        for(int i = 0 ; i < board.length ; i++)
        {
            for(int j = 0 ; j < board.length ; j++)
            {
                int sq = 0;
                if((board.length-i-1)%2 == 0)
                {
                    if((board.length-i-1) != 0)
                    {
                        sq = (board.length-i-1)*board.length+1+j;    
                    }
                    else
                    {
                        sq = 1+j;
                    }
                    
                }
                else
                {
                    sq =  (board.length-i)*board.length-j;
                }
                if(board[i][j] != -1)
                {
                   //System.out.println(i+ " " +j+ " "+sq + " " + board[i][j]);
                    map.put(sq,board[i][j]);
                }
            }
        }
        
        q.offerLast(1);
        visited[1] = true;
        int count = 0;
        int currNum = -1;
        int lvlCount = 1;
        int dis = 0;
        while(q.isEmpty() == false)
        {
            currNum = q.removeFirst();
            //System.out.println(currNum);
            lvlCount--;
            
            if(currNum == n)
            {
                break;
            }
            
            for(int dic = 1 ; dic < 7 ; dic++)
            {
               int newNum = map.getOrDefault(currNum+dic,currNum+dic);
               //System.out.println(">>> : "+ newNum);

               if(newNum <= n && visited[newNum] == false)
               {
                   visited[newNum] = true;
                   q.offerLast(newNum);
                   count++;
               }
            }
            
            if(lvlCount == 0)
            {
                lvlCount = count;
                dis++;
                count = 0;
            }
        }
        
        return (currNum == n)? dis : -1;
    }
}