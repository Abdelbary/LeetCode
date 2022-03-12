class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] { -1, -1 };
        if(nums.length == 0)
        {
            return result;
        }
        result[0] = lowerBound(nums,target);
        result[1] = upperBound(nums,target);

        return result;
  }

  static int lowerBound(int[] arr,int key)
  {
  
    int start = 0 ;
    int end = arr.length-1;
    int mid;

    while(start < end)
    {
      mid = start + (end - start)/2;

      if(arr[mid] < key)
      {
        start = mid+1;
      }
      else
      {
        end = mid;
      }
    }
    if(arr[start] != key)
    {
      return -1;
    }
    return start;
  }

  static int upperBound(int[] arr,int key)
  {
  
    int start = 0 ;
    int end = arr.length-1;
    int mid;

    while(start < end)
    {
      mid = start + (end -start+1)/2;

      if(arr[mid] <= key)
      {
        start = mid;
      }
      else
      {
        end = mid-1;
      }
    }
    if(arr[start] != key)
    {
      return -1;
    }
    return start;
  }
    
}