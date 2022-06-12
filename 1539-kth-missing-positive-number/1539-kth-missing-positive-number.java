class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int current_max = 1;
        int num = 1;
        for(int i = 0; i< arr.length ; i++,num++)
        {
            if(arr[i] != num)
            {
                if(arr[i]-num >= k)
                    return num + k - 1;
                k -= arr[i]-num;
                num = arr[i];
            }
        }
        
        return num + k -1;
    }
}