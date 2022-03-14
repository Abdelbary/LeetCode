class Solution {
    public int findDuplicate(int[] nums) {
        
        //return bitWiseSolution(nums);
        return cyclicSort(nums);
    }
    int cyclicSort(int[] nums)
    {
        int i = 0;
        // 1 , 3 ,4 , 2 ,2
        // 
        for( ; i < nums.length ; i++)
        {
            int rank = nums[i]-1;//0
            while(i != rank)//0,0 //
            {
                if(nums[rank] == nums[i])
                {
                    return nums[i];
                }
                int tmp = nums[rank];
                nums[rank] = nums[i];
                nums[i] = tmp;
                
                rank = nums[i]-1;
            }
            
          
        }
        
        return -1;
    }
    
    int bitWiseSolution(int[] nums)
    {
        int disticentMask = 0;
        
        for(int i = 1 ; i < nums.length ; i++)
        {
            disticentMask ^= i;
        }
        
        int arrayMask = 0;
        
        for(int num : nums)
        {
            arrayMask ^= num;
        }
        
        return arrayMask^disticentMask;
    }
}