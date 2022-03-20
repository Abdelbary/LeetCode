class Solution {
    public boolean circularArrayLoop(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        
        for(int i =0 ; i < nums.length ; i++)
        {
            if(vis[i] == false)
            {
                if(checkCycle(nums,i,vis) == true)
               {
                   return true;
               }
            }
        }
        return false;
    }
    
    boolean checkCycle(int[] nums,int i, boolean[] vis)
    {
        vis[i] = true;
        int fast = i;
        int slow = i;
        int n = nums.length;
        
        
        fast = (fast + nums[fast] + 1000*n)%n;
        vis[fast] = true;
        fast = (fast + nums[fast] + 1000*n)%n;//3,0,1,3,1
        vis[fast] = true;
        slow = (slow + nums[slow] + 1000*n)%n;//3.0
        
        while(fast != slow)
        {
            fast = (fast + nums[fast] + 1000*n)%n;
            vis[fast] = true;
            fast = (fast + nums[fast] + 1000*n)%n;//3,0,1,3,1
            vis[fast] = true;
            slow = (slow + nums[slow] + 1000*n)%n;//3.0
        }
        
        int start = slow;
        slow = (slow + nums[slow] + 1000*n)%n;
        boolean startSign = (nums[start] > 0);
        
        
        //one elment loop
        if(slow == start)
        {
            return false;
        }
        
        while(slow != start)
        {
            boolean currentSign = (nums[slow] > 0);
            
            if(currentSign != startSign )
            {
                return false;
            }
            
            slow = (slow + nums[slow] + 1000*n)%n;
            
           
        }
        
        return true;
    }
}