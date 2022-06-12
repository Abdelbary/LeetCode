class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length-1;
        int mid;
        
        if(arr[0] > k)
            return k;
        
        while(left < right)
        {
            mid = left + (right-left+1)/2;
            
            if(arr[mid]-mid <= k)
                left = mid;
            else
                right = mid-1;
        }
        
        return arr[left] + (k-(arr[left]-left-1));
    }
}