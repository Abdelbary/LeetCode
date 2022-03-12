/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
         return binarySearch(reader,0,Integer.MAX_VALUE,target);
    }
    
    int binarySearch(ArrayReader reader,int start,int end,int target)
    {
        int mid;
        
        while(start <= end)
        {
            mid = start + (end -start)/2;
            int value = reader.get(mid);
            
            if(value == target)
            {
                return mid;
            }
            if(value < target)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        
        return -1;
    }
}