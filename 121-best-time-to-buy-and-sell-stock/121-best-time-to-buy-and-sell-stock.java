class Solution {
    public int maxProfit(int[] prices) {
        int left = prices[0];
        int right = prices[0];
        int maxDiff = 0;
        for(int i = 0 ; i < prices.length ; i++)
        {
            if(prices[i] < left)
            {
                left = prices[i];
                right = prices[i];
            }
            if(prices[i] > right)
                right = prices[i];
            
            maxDiff = Math.max(maxDiff,right-left);
        }
        return maxDiff;
    }
}