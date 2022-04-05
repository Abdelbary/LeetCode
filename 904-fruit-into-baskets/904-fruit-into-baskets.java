class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int windowStart = 0;
        int ans = Integer.MIN_VALUE;
        
        for(int windowEnd = 0; windowEnd < fruits.length ; windowEnd++)
        {
            int fruitToInsert = fruits[windowEnd];
            
            map.put(fruitToInsert,map.getOrDefault(fruitToInsert,0)+1);
            
            while(map.size() > 2)
            {
                int fruiteToRemove = fruits[windowStart++];
                map.put(fruiteToRemove,map.get(fruiteToRemove)-1);
                
                if(map.get(fruiteToRemove) == 0)
                {
                    map.remove(fruiteToRemove);
                }
            }
            ans = Math.max(ans,windowEnd-windowStart+1);    
        }
        
        return ans;
    }
}