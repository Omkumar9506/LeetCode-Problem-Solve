class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        if (total % 2 != 0){
            return false;
        }
        return help(nums, total / 2);
    }

    boolean help(int[] nums, int target) {
        int n = nums.length;
        boolean prv[] = new boolean[target + 1];
        prv[0] = true;
        if (nums[0] <= target){
            prv[nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            boolean cur[] = new boolean[target + 1];
            for (int j = 1; j <= target; j++) {
                boolean notake = prv[j];
                boolean take = false;
                if (nums[i] < j) {
                    take = prv[j - nums[i]];
                }
                cur[j] = notake || take;
            }
            prv = cur;
        }
        return prv[target];
    }
}