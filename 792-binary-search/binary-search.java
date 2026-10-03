class Solution {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        return solve(nums, target, start, end);
    }
    public int solve(int[] nums, int target, int start, int end){
        if(start>end){
            return -1;
        }
        int mid=start+(end-start)/2;
        if(nums[mid]==target){
            return mid;
        }
        if(nums[mid]>target){
            end=mid-1;
        } else if(nums[mid]<target){
            start=mid+1;
        }
        return solve(nums, target, start, end);
    }
}