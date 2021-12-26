class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int[] ans = new int[n+m];
        int ind = 0;
        while(p1 < m && p2 < n)
        {
            if(nums1[p1] < nums2[p2])
            {
                ans[ind] = nums1[p1];
                p1++;
                ind++;
            }
            else
            {
                ans[ind] = nums2[p2];
                p2++;
                ind++;
            }
        }
        
        while(p1 < m)
        {
            ans[ind] = nums1[p1];
            ind++;
            p1++;
        }
        
        while(p2 < n)
        {
            ans[ind] = nums2[p2];
            ind++;
            p2++;
        }
                
        for(int i = 0 ; i < ans.length ; i++)
        {
            nums1[i] = ans[i];
        }
    }
}