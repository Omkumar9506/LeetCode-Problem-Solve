class Solution {
    public long minCost(int[] nums) {
        long dp0 = 0, dp1 = (long)1e15;
        int n = nums.length;
        for (int i = 1; i < n - 1; ++i) {
            long t = dp0;
            dp0 = Math.min(dp0, dp1 + nums[i]);
            dp1 = Math.min(dp1, t + nums[i]);
        }
        return dp0 + nums[0] + nums[n - 1];
    }
}