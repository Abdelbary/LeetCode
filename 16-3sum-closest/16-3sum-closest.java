class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE/2;
        Arrays.sort(nums);
        //[-1,-1,,1,1,3]
       for(int i = 0 ; i < nums.length-2 ; i++)
       {
           int left = i+1;
           int right = nums.length-1;
           
           while(left < right)
           {
               int sum = nums[i] + nums[left] + nums[right];
               
               closestSum = (Math.abs(closestSum-target)>Math.abs(sum-target))? sum : closestSum;
               
               if(sum >= target)
                   right--;
               else if(sum < target)
                   left++;
           }
       }
        
        return closestSum;
    }
}