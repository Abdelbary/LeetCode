class Solution {
    HashMap<Integer,ArrayList<Integer>> hubsMap = new HashMap<Integer,ArrayList<Integer>>();
    int[] dx = new int[]{2,1,-1,-2, 2, 1,-1,-2};
    int[] dy = new int[]{1,2, 2, 1,-1,-2,-2,-1};
    int[][] dialer = new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
    Integer[][] cache;
    
    public int knightDialer(int n) {
        
        int combinationNumbers = 0;
        cache = new Integer[10][n+1];
        
        for(int i = 0 ; i < 4 ; i++)
        {
            for(int j = 0 ; j < 3 ; j++)
            {
                int currentHub = i*3 + j + 1;
                if(currentHub == 11)
                {
                    currentHub = 0;
                }
                if(currentHub > 9)
                {
                    continue;
                }
                ArrayList<Integer> nextHubs = new ArrayList<Integer>();
                for(int k = 0 ; k < 8 ; k++)
                {
                    int newI = i + dy[k];
                    int newJ = j + dx[k];
                    if(newI >= 0 && newI < dialer.length && newJ >= 0 && newJ < dialer[0].length)
                    {
                        int newHub = newI*3 + newJ +1;
                        if(newHub == 11)
                        {
                            newHub = 0;
                        }
                        
                        if(newHub < 10)
                        {
                            nextHubs.add(newHub);
                        }
                    }
                }

                hubsMap.put(currentHub,nextHubs);
            }
        }
        
        for(int hub = 0 ; hub < 10 ; hub++)
        {
            //System.out.println(hub + " >> AVHUBS >>> " + hubsMap.get(hub));
            combinationNumbers =  (combinationNumbers%(1000_000_007)+countCombination(hub,n)%(1000_000_007))%(1000_000_007);
        }
        
        return combinationNumbers;
    }
    
    int countCombination(int indx, int hubsNumber)
    {
       //System.out.println(indx);
        if(hubsNumber == 1)
        {
            return 1;
        }
        
        if(cache[indx][hubsNumber] != null)
        {
            return cache[indx][hubsNumber];
        }
        
        int combinationNumbers = 0;
        
        List<Integer> aviableHubs = hubsMap.get(indx);
        
        for(Integer hub : aviableHubs)
        {
            combinationNumbers =  (combinationNumbers%(1000_000_007)+countCombination(hub,hubsNumber-1)%(1000_000_007))%(1000_000_007);
        }
        return cache[indx][hubsNumber] = combinationNumbers;
    }
    //construct an arry and then the stat [i,j,n] -> [i+dx,j+dy,n-1];
    //state [number,n] -> [theNextAvialableHub for number,n-1]
}

