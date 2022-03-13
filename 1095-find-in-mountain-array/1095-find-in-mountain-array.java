/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    int findPeakIndex(MountainArray mountainArr)
    {
        int start = 0 ;
        int end = mountainArr.length()-1;
        int mid;
        
        while(start < end)
        {
            mid = start + (end-start)/2;
            
            if(mid < mountainArr.length()-1 && mountainArr.get(mid) < mountainArr.get(mid + 1))
            {
                start = mid + 1;
            }
            else
            {
                end = mid;
            }
        }
        
        return start;
    }
    int binarySearch(MountainArray mountainArr,int start,int end,int target)
    {
        int mid;
        boolean asending = (mountainArr.get(start) <= mountainArr.get(end));
        
        if(asending)
        {
            while(start < end)
            {
                mid = start + (end - start)/2;

                if(mountainArr.get(mid) < target)
                {

                    start = mid + 1;
                }
                else
                {
                    end = mid;
                }
            }
        }else
        {
           while(start < end)
            {
                mid = start + (end - start + 1)/2;

                if(mountainArr.get(mid) >= target)
                {
                    start = mid;
                }
                else
                {
                    end = mid-1;
                }
            } 
        }
        
        if(mountainArr.get(start) != target)
        {
            return -1;
        }
        return start;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        int peek = findPeakIndex(mountainArr);
        int leftPos = binarySearch(mountainArr,0,peek-1,target);
        if( leftPos == -1)
        {
            leftPos = binarySearch(mountainArr,peek,mountainArr.length()-1,target);
        }
        
        return leftPos;
    }
}