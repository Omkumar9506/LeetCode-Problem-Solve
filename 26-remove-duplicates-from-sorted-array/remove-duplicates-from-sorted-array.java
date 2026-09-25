class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int j=1;
        int res=1;
        int n=nums.length;
        while(j<n){
            if(nums[j]==nums[j-1]){
                j++;
                continue;
            }
            nums[i+1]=nums[j];
            i++;
            res++;
            j++;
        }
        return res;
    }
}