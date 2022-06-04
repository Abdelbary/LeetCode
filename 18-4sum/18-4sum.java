class Solution {
     private  List<List<Integer>> twoSum(int[] arr,int target,int start)
      {
        int left = start;
        int right = arr.length-1;
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        while(left < right)
        {
          int sum = arr[left] + arr[right];

          if(sum == target)
          {
            result.add(new ArrayList<Integer>(Arrays.asList(arr[left],arr[right]))); 
            left++;
            right--;   
            while(left < arr.length && arr[left] == arr[left-1]) left++; // to remove duplicates
          }
          else if(sum > target)
            right--;
          else 
            left++;
        }
        return result;
      }

      private  List<List<Integer>> helper(int[] arr,int target,int level,int start)
      {
        if(level == 2)
          return twoSum(arr,target,start);

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i = start ; i <= arr.length - level ; i++)
        {
          if(i == start || arr[i] != arr[i-1])
          {
            List<List<Integer>> tmp =  helper(arr,target-arr[i],level-1,i+1);

            for(List<Integer> list : tmp)
              list.add(arr[i]);

            result.addAll(tmp);
          }
        }

        return result;
      }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> quadruplets = new ArrayList<>();
        // TODO: Write your code here
        quadruplets.addAll(helper(nums,target,4,0));
        return quadruplets;
    }
}
