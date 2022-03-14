class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int num = 0;
        int pos = 0;
        while(k > 0 && pos < arr.length)
        {
            num++;
            if(arr[pos] == num)
            {
                pos++;
            }
            else
            {
                k--;
            }
        }
        
        num+=k;
        
        return num;
    }
}